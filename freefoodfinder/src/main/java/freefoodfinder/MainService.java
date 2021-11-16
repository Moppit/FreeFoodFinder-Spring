package freefoodfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private LocationRepository locationRepository;

    public EventResponse getAllEvents() {
        return new EventResponse(eventRepository.findAll());
    }

    public LocationResponse getLocations() { return new LocationResponse(locationRepository.findAll()); }

}
