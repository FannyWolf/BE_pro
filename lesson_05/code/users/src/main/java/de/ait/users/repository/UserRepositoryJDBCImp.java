package de.ait.users.repository;

import de.ait.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryJDBCImp implements UserRepository {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryJDBCImp(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<User> userRowMapper = (row, rowNumber) -> {
        Long id = row.getLong("id");
        String username = row.getString("name");
        String email = row.getString("email");
        String password = row.getString("password");

        return new User(id, username, email, password);
    };

    @Override
    public List<User> findAll() {

         String queryStr = "SELECT * FROM t_user";
        return jdbcTemplate.query(queryStr, userRowMapper);
    }

    @Override
    public User save(User user) {
        return null;
    }
}
