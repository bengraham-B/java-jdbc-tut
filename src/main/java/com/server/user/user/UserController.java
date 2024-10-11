package com.server.user.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/users/") // --> http://localhost:8080/api/users/
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get All Users
    @GetMapping
    public List<User> getUsers(){
        System.out.println("Get All Users [" + LocalDate.now() + "]");
        return userRepository.findAll();
    }

    // Post User
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        int result = userRepository.saveUser(user);

        if (result > 0){
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        }

        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

}
