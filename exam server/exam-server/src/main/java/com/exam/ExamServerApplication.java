package com.exam;

import com.exam.helper.UserFoundException;
import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;




@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(ExamServerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("Coding is running");

			User user = new User();
			user.setFirstname("Aman");
			user.setLastname("Tayal");
			user.setUsername("aman2909");
			user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
			user.setEmail("****@gmail.com");
			user.setProfile("default.png");

			Role role1 = new Role();
			role1.setRoleId(10L);
			role1.setRoleName("ADMIN");
//
			Set<UserRole> userRoleSet = new HashSet<>();
			UserRole userRole = new UserRole();

			userRole.setRole(role1);

			userRole.setUser(user);

			userRoleSet.add(userRole);
//
			User user1 = this.userService.creatUser(user, userRoleSet);
			System.out.println(user1.getUsername());
		}
		catch (UserFoundException e) {
			e.printStackTrace();


		}
	}
}
