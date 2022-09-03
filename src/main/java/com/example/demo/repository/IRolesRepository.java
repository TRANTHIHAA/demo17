package com.example.demo.repository;

import com.example.demo.model.Roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolesRepository extends JpaRepository<Roles,Long> {
}
