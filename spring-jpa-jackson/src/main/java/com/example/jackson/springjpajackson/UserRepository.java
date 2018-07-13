package com.example.jackson.springjpajackson;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameLike(String name);
}
