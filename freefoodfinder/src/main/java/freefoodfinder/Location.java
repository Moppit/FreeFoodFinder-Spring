package freefoodfinder;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Location {

    // Table Columns
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer locationID;
    private String locationName;
    private String latitude;
    private String longitude;
    private Boolean InOrOutDoor;

    // Foreign Key
    @JsonBackReference
    @OneToMany(mappedBy="locationID")
    private Set<Event> events;

    // Constructors
    public Location() {}
    public Location(Integer locationID, String locationName, String latitude, String longitude, Boolean inOrOutDoor, Set<Event> events) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.InOrOutDoor = inOrOutDoor;
        this.events = events;
    }

    // Getters & Setters
    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Boolean getInOrOutDoor() {
        return InOrOutDoor;
    }

    public void setInOrOutDoor(Boolean inOrOutDoor) {
        InOrOutDoor = inOrOutDoor;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

}
