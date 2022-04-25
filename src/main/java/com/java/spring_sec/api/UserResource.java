package com.java.spring_sec.api;

import com.java.spring_sec.domain.Role;
import com.java.spring_sec.domain.User;
import com.java.spring_sec.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.getUser(username));
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping("/role")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping("/users/addRole")
    public ResponseEntity<?> addRole(@PathVariable AddRole form) {
        userService.addRoleToUser(form.getUsername(), form.getRole());
       return ResponseEntity.ok().build();
    }
}
@Data
class  AddRole {
    private String username;
    private String role;
}