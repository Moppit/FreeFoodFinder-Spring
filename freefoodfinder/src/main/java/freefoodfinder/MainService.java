package freefoodfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DietaryRestrictionRepository dietaryRestrictionRepository;

    public EventResponse getAllEvents() {
        return new EventResponse(eventRepository.findAll());
    }

    public LocationResponse getLocations() {
        return new LocationResponse(locationRepository.findAll());
    }

    public SingleEventResponse createEvent(CreateEventRequest req) {

        Optional<Location> location = locationRepository.findById(req.getLocationID());

        if (location.isPresent()) {
            DietaryRestriction dietaryRestriction = DietaryRestriction.fromCreateEventRequest(req);
            DietaryRestriction d = dietaryRestrictionRepository.save(dietaryRestriction);

            Event event = Event.fromCreateEventReq(req, d, location.get());

            return new SingleEventResponse(eventRepository.save(event));
        }

        return null;
    }

}
