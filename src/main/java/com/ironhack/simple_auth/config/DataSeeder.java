package com.ironhack.simple_auth.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ironhack.simple_auth.model.User;
import com.ironhack.simple_auth.repository.UserRepository;

/**
 * Seeds a demo user on startup so login works immediately during the lesson.
 *   email:    demo@ironhack.com
 *   password: password
 */
@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.existsByEmail("demo@ironhack.com")) {
            return;
        }

        User demo = new User();
        demo.setName("Demo User");
        demo.setEmail("demo@ironhack.com");
        demo.setPassword(passwordEncoder.encode("password"));
        demo.setRole("USER");

        userRepository.save(demo);
        System.out.println(">> Seeded demo user: demo@ironhack.com / password");
    }
}
