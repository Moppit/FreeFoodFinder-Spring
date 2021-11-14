package freefoodfinder;

import java.util.Set;

public class LocationResponse {

    private Set<Location> locations;

    public LocationResponse(Set<Location> locations) {
        this.locations = locations;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

}
