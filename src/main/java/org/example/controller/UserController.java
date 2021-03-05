package org.example.controller;

import org.example.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserInfo(
            @PathVariable("id") int userId) {
        User someUser = new User(1, "John", "Evans", "676-7673-63");

        return new ResponseEntity<>(someUser, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addUser() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserInfo(
            @PathVariable("id") int userId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUserInfo(
            @PathVariable("id") int userId) {

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
