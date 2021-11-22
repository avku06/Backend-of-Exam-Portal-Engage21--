package com.exam;


import com.exam.helper.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ExamserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            System.out.println("starting code");
            User user = new User();

            user.setFirstName("Pearl");
            user.setLastName("Gupta");
            user.setUsername("pearlgupta2891");
            user.setPassword(this.bCryptPasswordEncoder.encode("pearl"));
            user.setEmail("pearlgupta2000@gmail.com");
            user.setProfile("def.png");

            Role rol = new Role();
            rol.setRoleId(30L);
            rol.setRoleName("ADMIN");

            UserRole userRole = new UserRole();
            userRole.setRole(rol);
            userRole.setUser(user);

            Set<UserRole> userRoleSet = new HashSet<>();
            userRoleSet.add(userRole);

            User user1 = this.userService.CreateUser(user, userRoleSet);

        }catch (UserFoundException e) {
            e.printStackTrace();
        }

    }


}
