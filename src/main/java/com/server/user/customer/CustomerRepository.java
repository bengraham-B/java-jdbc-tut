package com.server.user.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // RowMapper
    private Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
        Customer customer = new Customer();
        customer.setName("RRS");
        customer.setAmount(69000.00);
        return customer;
    }

    // Create Customer
    public int createCustomer(Customer cus){
        String SQL = "INSERT INTO customer(name, amount) VALUES(?,?)";
        return jdbcTemplate.update(SQL, cus.getName(), cus.getAmount());
    }
}
