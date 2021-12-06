package freefoodfinder;

import java.util.*;

/**
 * Filter by specific criteria helper functions. Receives a value based on the request
 * params and return valid events.
 */
public class Filter {

    public Filter() { }

    public List<Event> filterBySearchTerm(List<Event> eventList, String searchTerm) {
        if(searchTerm == null) {
            return eventList;
        }
        else {
            List<Event> filteredEvents = new ArrayList<Event>();
            String search_lower = searchTerm.toLowerCase();
            for(Event e : eventList) {
                String name_lower = e.getFoodName().toLowerCase();
                String desc_lower = e.getFoodDescription().toLowerCase();
                if(name_lower.contains(search_lower) || desc_lower.contains(search_lower)) {
                    filteredEvents.add(e);
                }
            }
            return filteredEvents;
        }
    }

    public List<Event> filterByLocation(List<Event> eventList, Location location) {
        if(location == null) {
            return eventList;
        }
        else {
            List<Event> filteredEvents = new ArrayList<Event>();
            for(Event e : eventList) {
                if(e.getLocationID().getLocationID() == location.getLocationID()) {
                    filteredEvents.add(e);
                }
            }
            return filteredEvents;
        }
    }

    public List<Event> filterByRestrictions(List<Event> eventList, List<String> filters) {
        if(filters == null) {
            return eventList;
        }
        else {
            List<Event> filteredEvents = new ArrayList<Event>();
            for(Event e : eventList) {
                if(e.getRestrictionID().hasFilters(filters)) {
                    filteredEvents.add(e);
                }
            }
            return filteredEvents;
        }
    }
}
