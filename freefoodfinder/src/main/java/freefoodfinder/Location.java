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
    private Float latitude;
    private Float longitude;
    private String address;
    private Boolean isOutdoor;

    // Foreign Key
    @JsonBackReference
    @OneToMany(mappedBy="locationID")
    private Set<Event> events;

    // Constructors
    public Location() {}
    public Location(Integer locationID, String locationName, Float latitude, Float longitude, String address, Boolean isOutdoor, Set<Event> events) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.isOutdoor = isOutdoor;
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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String longitude) {
        this.address = address;
    }

    public Boolean getIsOutdoor() {
        return isOutdoor;
    }

    public void setIsOutdoor(Boolean isOutdoor) {
        this.isOutdoor = isOutdoor;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

}
