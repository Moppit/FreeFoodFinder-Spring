package freefoodfinder;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;

// CRUD = CREATE, READ, UPDATE, DELETE -- implements these for you
public interface EventRepository extends CrudRepository<Event, Integer> {

    // Find all non-expired events
    Iterable<Event> findByAvailableUntilAfter(Timestamp currTime);

    // Filtered Variants
    Iterable<Event> findByAvailableUntilAfterAndFoodDescriptionContaining(Timestamp currTime, String searchTerm);

    Iterable<Event> findByAvailableUntilAfterAndLocationIDEquals(Timestamp currTime, Location locationID);

    Iterable<Event> findByAvailableUntilAfterAndFoodDescriptionContainingAndLocationIDEquals(Timestamp currTime, String searchTerm, Location locationID);

}
