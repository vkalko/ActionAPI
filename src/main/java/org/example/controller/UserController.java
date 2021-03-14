package org.example.controller;

import org.example.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserInfo(
            @PathVariable("id") int userId) {
        UserDTO someUser = new UserDTO(userId, "John", "Evans", "676-7673-63");
        someUser.add(linkTo(methodOn(UserController.class)
                        .getUserInfo(someUser.getUserId())).withSelfRel(),
                linkTo(methodOn(DocumentController.class)
                        .getAllowedDocuments()).withRel("documents"),
                linkTo(methodOn(ServiceController.class)
                        .getServicesList()).withRel("services-list"));

        return new ResponseEntity<>(someUser, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addUser() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserInfo(
            @PathVariable("id") int userId) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUserInfo(
            @PathVariable("id") int userId) {

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
