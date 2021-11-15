package freefoodfinder;

public class EventResponse {

    private Iterable<Event> events;

    public EventResponse(Iterable<Event> events) {
        this.events = events;
    }

    public Iterable<Event> getEvents() {
        return events;
    }

    public void setEvents(Iterable<Event> events) {
        this.events = events;
    }

}
