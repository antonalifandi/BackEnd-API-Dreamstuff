package com.application.dreamstuffapplicationapi.controllers;

import com.application.dreamstuffapplicationapi.models.Users;
import com.application.dreamstuffapplicationapi.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ControllerUsers {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> getAll() {
        return usersService.getAll();
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable Long id) {
        return usersService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@RequestBody Users users) {
        Users savedUser = usersService.addUsers(users);
        return savedUser;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") Long id, @RequestBody Users users) {
        Users existingUser = usersService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        users.setUser_id(id);
        Users updatedUser = usersService.updateUsers(users);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public Users deleteUser(@PathVariable Long id) {
        Users user = usersService.getById(id);
        if (user != null) {
            usersService.deleteUsers(id);
        }
        return user;
    }

}
