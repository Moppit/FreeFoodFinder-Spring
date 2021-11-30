package freefoodfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fff")
public class MainController {

    @Autowired
    private MainService service;

    @CrossOrigin
    @GetMapping("/events")
    public @ResponseBody
    EventResponse getAllEvents() {
        return this.service.getAllEvents();
    }

    @CrossOrigin
    @GetMapping("/locations")
    public @ResponseBody
    LocationResponse getLocations() {
        return this.service.getLocations();
    }

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
