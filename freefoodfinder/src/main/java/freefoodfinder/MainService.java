package freefoodfinder;

import org.springframework.stereotype.Service;

@Service
public class MainService {

    private EventRepository eventRepository;

    public EventResponse getAllEvents() {
        return new EventResponse(eventRepository.findAll());
    }

}
