package com.tech.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.model.User;

public interface UserRepository extends JpaRepository<com.tech.model.User, Long> {
    User findByUsername(String username);
}
