package freefoodfinder;

import java.util.Set;
import javax.persistence.*;

@Entity
public class EventResponse {

    private Set<Event> events;

    public EventResponse(Set<Event> events) {
        this.events = events;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

}
