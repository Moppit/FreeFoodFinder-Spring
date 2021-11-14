package freefoodfinder;

import java.util.Set;
import javax.persistence.*;

@Entity
public class DietaryRestrictions {

    // Table Columns
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer restrictionID;
    private Boolean glutenFree;
    private Boolean vegan;
    private Boolean vegetarian;
    private Boolean noPeanut;
    private Boolean lactoseFree;
    private Boolean kosher;
    private Boolean noEgg;
    private Boolean noSoy;

    // Foreign Key
    @OneToMany(mappedBy="DietaryRestrictions")
    private Set<Event> events;

    // Getters & Setters
    public Integer getRestrictionID() {
        return restrictionID;
    }

    public void setRestrictionID(Integer restrictionID) {
        this.restrictionID = restrictionID;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getNoPeanut() {
        return noPeanut;
    }

    public void setNoPeanut(Boolean noPeanut) {
        this.noPeanut = noPeanut;
    }

    public Boolean getLactoseFree() {
        return lactoseFree;
    }

    public void setLactoseFree(Boolean lactoseFree) {
        this.lactoseFree = lactoseFree;
    }

    public Boolean getKosher() {
        return kosher;
    }

    public void setKosher(Boolean kosher) {
        this.kosher = kosher;
    }

    public Boolean getNoEgg() {
        return noEgg;
    }

    public void setNoEgg(Boolean noEgg) {
        this.noEgg = noEgg;
    }

    public Boolean getNoSoy() {
        return noSoy;
    }

    public void setNoSoy(Boolean noSoy) {
        this.noSoy = noSoy;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

}
