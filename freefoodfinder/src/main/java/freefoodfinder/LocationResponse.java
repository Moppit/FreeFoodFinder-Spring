package freefoodfinder;

public class LocationResponse {

    private Iterable<Location> locations;

    public LocationResponse(Iterable<Location> locations) {
        this.locations = locations;
    }

    public Iterable<Location> getLocations() {
        return locations;
    }

    public void setLocations(Iterable<Location> locations) {
        this.locations = locations;
    }

}
