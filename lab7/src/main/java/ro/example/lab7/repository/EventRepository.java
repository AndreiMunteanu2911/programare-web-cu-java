
package ro.example.lab7.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ro.example.lab7.model.Event;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

    private static final RowMapper<Event> EVENT_ROW_MAPPER = (row, rowNum) ->
            new Event(row.getLong("id"), row.getString("name"), row.getString("category"));

    private final JdbcTemplate jdbcTemplate;

    public EventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // EXERCISE 2 - JdbcTemplate

    // DONE 1: Retrieve all events from the database.
    // Use jdbcTemplate.query() and a RowMapper.
    public List<Event> findAll() {
        return jdbcTemplate.query("SELECT id, name, category FROM events ORDER BY id", EVENT_ROW_MAPPER);
    }

    // DONE 2: Find an event by ID using a parameterized query.
    // Return Optional.empty() when the event does not exist.
    public Optional<Event> findById(long id) {
        return jdbcTemplate.query(
                "SELECT id, name, category FROM events WHERE id = ?", EVENT_ROW_MAPPER, id
        ).stream().findFirst();
    }


    // EXERCISE 3 - Database Operations

    // DONE 3: Insert a new event into the database.
    // Use INSERT ... RETURNING id to retrieve the generated ID.
    public Long save(String name, String category) {
        return jdbcTemplate.queryForObject(
                "INSERT INTO events (name, category) VALUES (?, ?) RETURNING id",
                Long.class, name, category
        );
    }

    // DONE 4: Update an existing event by ID.
    // Return the number of affected rows.
    public int updateById(long id, String name, String category) {
        return jdbcTemplate.update(
                "UPDATE events SET name = ?, category = ? WHERE id = ?", name, category, id
        );
    }

    // DONE 5: Delete an event by ID.
    // Return the number of affected rows.
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM events WHERE id = ?", id);
    }
}
