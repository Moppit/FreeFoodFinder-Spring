package freefoodfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fff")
public class MainController {

    @Autowired
    private MainService service;

    /**
     * GET /fff/events
     * Retrieves events from database. Has optional params for filtering.
     */
    @CrossOrigin
    @GetMapping("/events")
    public @ResponseBody
    EventResponse getEvents(@RequestParam(value = "search", required = false) String searchTerm,
                            @RequestParam(value = "location", required = false) Integer locationID,
                            @RequestParam(value = "filters", required = false) String filters) {
        return this.service.getEvents(searchTerm, locationID, filters);
    }

    /**
     * GET /fff/locations
     * Retrieves all locations from database.
     */
    @CrossOrigin
    @GetMapping("/locations")
    public @ResponseBody
    LocationResponse getLocations() {
        return this.service.getLocations();
    }

    /**
     * POST /fff/events
     * Adds a new food event to the database.
     */
    @CrossOrigin
    @PostMapping("/events")
    public @ResponseBody
    SingleEventResponse createEvent(@RequestBody CreateEventRequest request) {
        return this.service.createEvent(request);
    }

}
