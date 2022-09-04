package com.example.demo.repository;

import com.example.demo.model.Foods;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFoodRepository extends JpaRepository<Foods,Long> {
    @Query(value = "select * from foods where name like :name", nativeQuery = true)
    Page<Foods> findAllByNameContaining(Pageable pageable, String name);
}
