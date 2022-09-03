package com.example.demo.repository;

import com.example.demo.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepository extends JpaRepository<Restaurants,Long> {
}
