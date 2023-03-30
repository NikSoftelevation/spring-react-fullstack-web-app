package com.NikSoftelevation.springbootreactjsfullstack.web;

import com.NikSoftelevation.springbootreactjsfullstack.model.User;
import com.NikSoftelevation.springbootreactjsfullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") Long userId) {
        User updatedUser = userService.updateUser(user, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> getAllUsers = userService.getAllUsers();
        return new ResponseEntity<>(getAllUsers, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable("userId") Long userId) {
        User userByUserId = userService.getUserByUserId(userId);

        return new ResponseEntity<>(userByUserId, HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUserByUserId(@PathVariable("userId") Long userId) {
        userService.deleteUserByUserId(userId);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}