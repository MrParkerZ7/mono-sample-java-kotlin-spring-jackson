package com.example.jackson.springjpajackson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("Park",
                "I have to make imagination programming for my ... nothing actually."));
        userRepository.save(new User("Macro",
                "I'm a imagination programming I was built for some purpose of human. " +
                        "To help them or some thing advance maybe."));
        userRepository.save(new User("KillerIsDead",
                "I Just gonna kill something."));
        userRepository.save(new User("Darkness",
                "Actually I'm just a shadow. but, " +
                        "People are afraid of me because of they can't see anything without the light."));
    }
}
