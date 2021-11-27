package freefoodfinder;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class CreateEventRequest {
    private String name;

    private String desc;

    private int locationID;

    private String room;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Timestamp availableUntil;

    private boolean glutenFree;

    private boolean lactoseFree;

    private boolean vegan;

    private boolean kosher;

    private boolean vegetarian;

    private boolean noEggs;

    private boolean noPeanuts;

    private boolean noSoy;

    public CreateEventRequest(String name,
                              String desc,
                              int locationID,
                              String room,
                              Timestamp availableUntil,
                              boolean glutenFree,
                              boolean lactoseFree,
                              boolean vegan,
                              boolean kosher,
                              boolean vegetarian,
                              boolean noEggs,
                              boolean noPeanuts,
                              boolean noSoy) {
        this.name = name;
        this.desc = desc;
        this.locationID = locationID;
        this.room = room;
        this.availableUntil = availableUntil;
        this.glutenFree = glutenFree;
        this.lactoseFree = lactoseFree;
        this.vegan = vegan;
        this.kosher = kosher;
        this.vegetarian = vegetarian;
        this.noEggs = noEggs;
        this.noPeanuts = noPeanuts;
        this.noSoy = noSoy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Timestamp getAvailableUntil() {
        return availableUntil;
    }

    public void setAvailableUntil(Timestamp availableUntil) {
        this.availableUntil = availableUntil;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isLactoseFree() {
        return lactoseFree;
    }

    public void setLactoseFree(boolean lactoseFree) {
        this.lactoseFree = lactoseFree;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isKosher() {
        return kosher;
    }

    public void setKosher(boolean kosher) {
        this.kosher = kosher;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isNoEggs() {
        return noEggs;
    }

    public void setNoEggs(boolean noEggs) {
        this.noEggs = noEggs;
    }

    public boolean isNoPeanuts() {
        return noPeanuts;
    }

    public void setNoPeanuts(boolean noPeanuts) {
        this.noPeanuts = noPeanuts;
    }

    public boolean isNoSoy() {
        return noSoy;
    }

    public void setNoSoy(boolean noSoy) {
        this.noSoy = noSoy;
    }
}
