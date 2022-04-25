package com.java.spring_sec.service;

import com.java.spring_sec.domain.Role;
import com.java.spring_sec.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}