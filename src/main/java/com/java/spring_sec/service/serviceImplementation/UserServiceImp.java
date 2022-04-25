package com.java.spring_sec.service.serviceImplementation;

import com.java.spring_sec.domain.Role;
import com.java.spring_sec.domain.User;
import com.java.spring_sec.repository.RoleRepository;
import com.java.spring_sec.repository.UserRepo;
import com.java.spring_sec.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImp implements UserService {
    private final UserRepo userRepository;
    private final RoleRepository roleRepository;
    @Override
    public User saveUser(User user) {
        log.info("Saving new user");
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {}", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
    User user = userRepository.findByUsername(username);
    Role role = roleRepository.findByName(roleName);
    user.getRoles().add(role);
    userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        log.info("Getting user");
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Getting users");
        return userRepository.findAll();
    }
}
