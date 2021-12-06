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

    public EventResponse getAllEvents() {return new EventResponse(eventRepository.findAll());}

    /**
     * Retrieves non-expired events from database. If all params are null, it returns all events. [1]
     * @param searchTerm (optional): search terms entered by user to search for matching food descriptions
     * @param locationID (optional): database key for the desired location
     * @param strFilters (optional): desired filters in the form of an un-parsed string
     * @return EventResponse: list of Event objects bundled into a response object
     */
    public EventResponse getEvents(String searchTerm, Integer locationID, String strFilters) {

        // Init Items
        Date date = new Date();
        Timestamp currTime = new Timestamp(date.getTime());
        Filter f = new Filter();
        Location location = locationID != null ? locationRepository.findById(locationID).get() : null;
        List<String> filters = strFilters != null ? Arrays.asList(strFilters.split(",")) : null;

        // Filter Events
        List<Event> events = new ArrayList<>();
        eventRepository.findByAvailableUntilAfter(currTime).forEach(events::add);
        events = f.filterBySearchTerm(events, searchTerm);
        events = f.filterByLocation(events, location);
        events = f.filterByRestrictions(events, filters);

        return new EventResponse(events);
    }

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

    /**
     * Increment the number of times an event has been reported.
     * @param id: EventID of event to increment
     * @return: None
     */
    public void reportEvent(Integer id) {
        Optional<Event> e = eventRepository.findById(id);
        if(e.isPresent()){
            Event event = e.get();
            event.setReports(event.getReports() + 1);
            eventRepository.save(event);
        }
    }

}

/******** References/Citations ********
 [1] Dealing with null request params: https://zetcode.com/springboot/requestparam/
 */
