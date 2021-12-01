package freefoodfinder;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;

// CRUD = CREATE, READ, UPDATE, DELETE -- implements these for you
public interface EventRepository extends CrudRepository<Event, Integer> {

    // Find all non-expired events
    Iterable<Event> findByAvailableUntilAfter(Timestamp currTime);

    // Filtered Variants [1]
    Iterable<Event> findByAvailableUntilAfterAndFoodDescriptionContaining(Timestamp currTime, String searchTerm);

    Iterable<Event> findByAvailableUntilAfterAndLocationIDEquals(Timestamp currTime, Location locationID);

    Iterable<Event> findByAvailableUntilAfterAndFoodDescriptionContainingAndLocationIDEquals(Timestamp currTime, String searchTerm, Location locationID);

}

/******** References/Citations ********
 [1] How to create queries: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
