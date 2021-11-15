package freefoodfinder;

import org.springframework.data.repository.CrudRepository;

// CRUD = CREATE, READ, UPDATE, DELETE -- implements these for you
public interface EventRepository extends CrudRepository<Event, Integer> {
}
