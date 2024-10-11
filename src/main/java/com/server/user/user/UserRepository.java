package com.server.user.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper ro convert ResultSet to User Object
    private User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        return user;
    }

    // Get users
    public List<User> findAll(){
        String SQL = "SELECT * FROM users";
        return jdbcTemplate.query(SQL, this::mapRow);
    }

    // Create User
    public int saveUser(User user){
        String SQL = "INSERT INTO users(name, email) VALUES(?,?)";
        return jdbcTemplate.update(SQL, user.getName(), user.getEmail());
    }


}
