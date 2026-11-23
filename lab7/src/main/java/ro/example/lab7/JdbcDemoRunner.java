
package ro.example.lab7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
@Profile("jdbc-demo")
public class JdbcDemoRunner implements CommandLineRunner {

    private final DataSource dataSource;

    public JdbcDemoRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {

        long eventId = 2L;

        // EXERCISE 1 - JDBC Fundamentals

        // DONE 1: Obtain a Connection from the DataSource.
        // Use try-with-resources.
        try (Connection connection = dataSource.getConnection()) {
            // DONE 2: Create a PreparedStatement that selects
            // an event by its ID.
            String sql = "SELECT id, name, category FROM events WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // DONE 3: Bind eventId to the SQL parameter.
                statement.setLong(1, eventId);

                // DONE 4: Execute the query and obtain a ResultSet.
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        // DONE 5: Read and display the event's
                        // id, name and category.
                        System.out.printf("Event %d: %s (%s)%n",
                                result.getLong("id"),
                                result.getString("name"),
                                result.getString("category"));
                    } else {
                        // DONE 6: Handle the case when no event is found.
                        System.out.println("No event found with ID " + eventId);
                    }
                }
            }
        }
    }
}
