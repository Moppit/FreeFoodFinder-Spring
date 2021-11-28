package freefoodfinder;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;

// CRUD = CREATE, READ, UPDATE, DELETE -- implements these for you
public interface EventRepository extends CrudRepository<Event, Integer> {

    // Find all non-expired events
    Iterable<Event> findByAvailableUntilAfter(Timestamp currTime);

}
