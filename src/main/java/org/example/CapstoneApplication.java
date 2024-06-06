package org.example;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class CapstoneApplication {

    private static final Logger logger = LoggerFactory.getLogger(CapstoneApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CapstoneApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return args -> {
            logger.info("Checking if default users exist...");
            if (!userRepository.existsByUsername("user")) {
                User user = new User();
                user.setUsername("user");
                user.setPassword("{noop}password"); // Klartextpasswort mit {noop} markiert
                user.setRoles(Set.of("USER"));
                userRepository.save(user);
                logger.info("Default user created: user");
            } else {
                logger.info("Default user already exists: user");
            }

            if (!userRepository.existsByUsername("admin")) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("{noop}adminpassword"); // Klartextpasswort mit {noop} markiert
                admin.setRoles(Set.of("ADMIN"));
                userRepository.save(admin);
                logger.info("Default admin created: admin");
            } else {
                logger.info("Default admin already exists: admin");
            }
        };
    }
}
