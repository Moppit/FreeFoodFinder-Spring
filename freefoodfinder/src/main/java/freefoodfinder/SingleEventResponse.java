package freefoodfinder;

public class SingleEventResponse {
    private Event event;

    public SingleEventResponse(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
