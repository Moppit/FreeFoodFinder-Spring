package freefoodfinder;

import java.sql.Timestamp;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {

    // Find all non-expired events [1]
    Iterable<Event> findByAvailableUntilAfter(Timestamp currTime);

}

/******** References/Citations ********
 [1] How to create queries: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
