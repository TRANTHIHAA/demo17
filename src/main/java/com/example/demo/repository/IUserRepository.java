package com.example.demo.repository;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByName(String name);
    Users findByEmail(String email);
}
