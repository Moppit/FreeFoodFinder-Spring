package freefoodfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fff")
public class MainController {

    @Autowired
    private MainService service;

    @GetMapping("/events")
    public @ResponseBody EventResponse getAllEvents() {
        return this.service.getAllEvents();
    }

}
