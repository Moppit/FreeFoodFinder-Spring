package freefoodfinder;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Optional;

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

    public EventResponse getAllEvents() {
        Date date = new Date();
        Iterable<Event> events = eventRepository.findByAvailableUntilAfter(new Timestamp(date.getTime()));
        return new EventResponse(events);
    }

    public LocationResponse getLocations() {
        return new LocationResponse(locationRepository.findAll());
    }

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
