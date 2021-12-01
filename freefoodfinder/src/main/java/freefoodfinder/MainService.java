package freefoodfinder;

import java.util.*;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DietaryRestrictionRepository dietaryRestrictionRepository;

    /**
     * Retrieves non-expired events from database. If all params are null, it returns all events. [1]
     * @param searchTerm (optional): search terms entered by user to search for matching food descriptions
     * @param locationID (optional): database key for the desired location
     * @param strFilters (optional): desired filters in the form of an un-parsed string
     * @return EventResponse: list of Event objects bundled into a response object
     */
    public EventResponse getEvents(String searchTerm, Integer locationID, String strFilters) {
        Date date = new Date();
        Timestamp currTime = new Timestamp(date.getTime());
        Iterable<Event> events;
        Location location = locationID != null ? locationRepository.findById(locationID).get() : null;
        List<String> filters = strFilters != null ? Arrays.asList(strFilters.split(",")) : null;

        // Make appropriate query based on whether searchTerm and location params are null
        if(searchTerm != null && location != null) {
            events = eventRepository.findByAvailableUntilAfterAndFoodDescriptionContainingAndLocationIDEquals(currTime, searchTerm, location);
        }
        else if(searchTerm != null) {
            events = eventRepository.findByAvailableUntilAfterAndFoodDescriptionContaining(currTime, searchTerm);
        }
        else if(location != null) {
            events = eventRepository.findByAvailableUntilAfterAndLocationIDEquals(currTime, location);
        }
        else {
            events = eventRepository.findByAvailableUntilAfter(currTime);
        }

        // If given filters, create dietary restrictions object given filters, then compare
        if(filters != null) {
            List<Event> filteredEvents = new ArrayList<Event>();
            for(Event e : events) {
                if(e.getRestrictionID().hasFilters(filters)) {
                    filteredEvents.add(e);
                }
            }
            return new EventResponse(filteredEvents);
        }

        return new EventResponse(events);
    }

    // TODO: add a delete function

    /**
     * Retrieves all locations in the database.
     * @return LocationResponse: list of all Locations bundled into a response object.
     */
    public LocationResponse getLocations() {
        return new LocationResponse(locationRepository.findAll());
    }

    /**
     * Create an event object
     * @param req: Request Body for create event POST request
     * @return: Event Response or null
     */
    public SingleEventResponse createEvent(CreateEventRequest req) {

        Optional<Location> location = locationRepository.findById(req.getLocationID());

        if (location.isPresent()) {
            DietaryRestriction dietaryRestriction = DietaryRestriction.fromCreateEventRequest(req);

            Event event = Event.fromCreateEventReq(req, dietaryRestriction, location.get());


            return new SingleEventResponse(eventRepository.save(event));
        }

        return null;
    }

}

/******** References/Citations ********
 [1] Dealing with null request params: https://zetcode.com/springboot/requestparam/
 */
