package freefoodfinder;

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

    // Foreign Key [1] [2]
    @JsonBackReference
    @OneToOne(mappedBy = "restrictionID", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Event event;

    // Constructors
    public DietaryRestriction() {
        this.glutenFree = false;
        this.vegan = false;
        this.vegetarian = false;
        this.noPeanut = false;
        this.lactoseFree = false;
        this.kosher = false;
        this.noEgg = false;
        this.noSoy = false;
    }

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

    /**
     * Verifies that an event's dietary restrictions have _at least_ the specified filters.
     * NOTE: that doesn't mean the filters match, just that the event has said filters.
     * i.e. a query for VEGAN food should return true for an event with VEGAN=true and NO_EGGS=true
     * @param filters: list of filters as strings
     * @return: true if this DietaryRestriction object has the desired filters set to true
     */
    public boolean hasFilters(Iterable<String> filters) {
        // Filter format: GLUTEN_FREE,LACTOSE_FREE,VEGAN,KOSHER,VEGETARIAN,NO_EGGS,NO_PEANUTS,NO_SOY
        for(String i : filters) {
            if("GLUTEN_FREE".equals(i)) { if(!getGlutenFree()) { return false; } }
            if("LACTOSE_FREE".equals(i)) { if(!getLactoseFree()) { return false; } }
            if("VEGAN".equals(i)) { if(!getVegan()) { return false; } }
            if("KOSHER".equals(i)) { if(!getKosher()) { return false; } }
            if("VEGETARIAN".equals(i)) { if(!getVegetarian()) { return false; } }
            if("NO_EGGS".equals(i)) { if(!getNoEgg()) { return false; } }
            if("NO_PEANUTS".equals(i)) { if(!getNoPeanut()) { return false; } }
            if("NO_SOY".equals(i)) { if(!getNoSoy()) { return false; } }
        }
        return true;
    }

}
/******** References/Citations ********
 [1] Foreign Keys in Spring: https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-foreign-key-example/
 [2] Prevent infinite references: https://stackoverflow.com/questions/30892298/infinite-loop-with-spring-boot-in-a-one-to-many-relation
 */