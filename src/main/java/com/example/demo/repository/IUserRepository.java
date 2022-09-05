package com.example.demo.repository;

import com.example.demo.model.Foods;
import com.example.demo.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<Users,Long> {
    Page<Users> findAllByNameContaining(Pageable pageable, String name);
    Optional<Users> findByName(String name);
    Users findByEmail(String email);
}
