package freefoodfinder;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
public class Event {

    // Table Columns
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer eventID;
    private String foodName;
    private Timestamp availableUntil;
    private String foodDescription;
    private String roomNumber;

    // Foreign Keys
    @ManyToOne
    @JoinColumn(name="restrictionID", nullable = false)
    private DietaryRestrictions restrictionID;

    @ManyToOne
    @JoinColumn(name="locationID", nullable = false)
    private Location locationID;

    // Constructor
    public Event(Integer eventID, String foodName, Timestamp availableUntil, String foodDescription, String roomNumber, DietaryRestrictions restrictionID, Location locationID) {
        this.eventID = eventID;
        this.foodName = foodName;
        this.availableUntil = availableUntil;
        this.foodDescription = foodDescription;
        this.roomNumber = roomNumber;
        this.restrictionID = restrictionID;
        this.locationID = locationID;
    }

    // Getters & Setters
    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Timestamp getAvailableUntil() {
        return availableUntil;
    }

    public void setAvailableUntil(Timestamp availableUntil) {
        this.availableUntil = availableUntil;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public DietaryRestrictions getRestrictionID() {
        return restrictionID;
    }

    public void setRestrictionID(DietaryRestrictions restrictionID) {
        this.restrictionID = restrictionID;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }

}
