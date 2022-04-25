package com.java.spring_sec;

import com.java.spring_sec.domain.Role;
import com.java.spring_sec.domain.User;
import com.java.spring_sec.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecApplication.class, args);
	}
@Bean
	CommandLineRunner run(UserService userService){
	return args -> {
		userService.saveRole(new Role(null,"ROLE_ADMIN"));
		userService.saveRole(new Role(null,"ROLE_USER"));
		userService.saveRole(new Role(null,"ROLE_MANAGER"));
		userService.saveRole(new Role(null,"ROLE_EMPLOYEE"));
		userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
		userService.saveUser(new User(null,"David","David123","123456789",new ArrayList<>()));
		userService.saveUser(new User(null,"John","John123","123456789",new ArrayList<>()));
		userService.saveUser(new User(null,"Mary","Mary123","123456789",new ArrayList<>()));
		userService.saveUser(new User(null,"Peter","Peter123","123456789",new ArrayList<>()));
		userService.saveUser(new User(null,"Paul","Paul123","123456789",new ArrayList<>()));
		userService.addRoleToUser("David","ROLE_ADMIN");
		userService.addRoleToUser("David","ROLE_USER");
		userService.addRoleToUser("John","ROLE_USER");
		userService.addRoleToUser("Mary","ROLE_MANAGER");
		userService.addRoleToUser("Peter","ROLE_EMPLOYEE");
		userService.addRoleToUser("Paul","ROLE_SUPER_ADMIN");
	};
}
}
