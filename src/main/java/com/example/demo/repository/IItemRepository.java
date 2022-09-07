package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "select * from item where cart_id = (select  cart.users_id from cart where users_id = ?1)", nativeQuery = true)
    List<Item> findItemByUsersId(@Param("id") Long id);
}