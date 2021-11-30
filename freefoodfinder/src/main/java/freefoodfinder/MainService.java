package freefoodfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    public EventResponse getAllEvents() {return new EventResponse(eventRepository.findAll());}

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

    public void reportEvent(Integer id) {
        Optional<Event> e = eventRepository.findById(id);
        if(e.isPresent()){
            Event event = e.get();
            event.setReports(event.getReports() + 1);
            eventRepository.save(event);
        }
    }

}
