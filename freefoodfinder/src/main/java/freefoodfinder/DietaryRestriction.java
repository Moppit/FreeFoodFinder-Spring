package freefoodfinder;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name="dietary_restriction")
public class DietaryRestriction {

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

    @JsonBackReference
    @OneToOne(mappedBy = "restrictionID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Event event;

    // Constructors
    public DietaryRestriction() {}
    public DietaryRestriction(Boolean glutenFree, Boolean vegan, Boolean vegetarian, Boolean noPeanut, Boolean lactoseFree, Boolean kosher, Boolean noEgg, Boolean noSoy, Event event) {
        this.glutenFree = glutenFree;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.noPeanut = noPeanut;
        this.lactoseFree = lactoseFree;
        this.kosher = kosher;
        this.noEgg = noEgg;
        this.noSoy = noSoy;
        this.event = event;
    }

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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public static DietaryRestriction fromCreateEventRequest(CreateEventRequest req) {
        DietaryRestriction d = new DietaryRestriction();
        d.setGlutenFree(req.isGlutenFree());
        d.setVegan(req.isVegan());
        d.setVegetarian(req.isVegetarian());
        d.setNoPeanut(req.isNoPeanuts());
        d.setLactoseFree(req.isLactoseFree());
        d.setKosher(req.isKosher());
        d.setNoEgg(req.isNoEggs());
        d.setNoSoy(req.isNoSoy());
        return d;
    }

}
