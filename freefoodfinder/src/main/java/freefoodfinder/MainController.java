package freefoodfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * | | | | | | | | | | | | |
 * |                       |
 * |       Singleton       |
 * |                       |
 * | | | | | | | | | | | | |
 *
 * Spring maintains one global instance of the Controller.
 *
 */
@Controller
@RequestMapping("/fff")
public class MainController {

    // Autowired to prevent null instance [2]
    @Autowired
    private MainService service;

    /**
     * GET /fff/events
     * Retrieves events from database. Has optional params for filtering [1].
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

    @CrossOrigin
    @PutMapping("/events/{id}/reports")
    public ResponseEntity<Void> reportEvent(@PathVariable final Integer id) {
        this.service.reportEvent(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}

/******** References/Citations ********
 [1] Optional params: https://stackoverflow.com/questions/22373696/requestparam-in-spring-mvc-handling-optional-parameters
 [2] Prevent null instance: https://stackoverflow.com/questions/64001667/cannot-invoke-because-is-null
 */