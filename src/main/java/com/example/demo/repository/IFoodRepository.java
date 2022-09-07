package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFoodRepository extends JpaRepository<Foods,Long> {
    @Query(value = "select * from foods where name like :name", nativeQuery = true)
    Page<Foods> findAllByNameContaining(Pageable pageable, String name);
    @Query(value = "select * from foods join category on category.id = foods.category_id where category.name like :name", nativeQuery = true)
    Page<Foods> findFoodByCategoryContaining (@Param("name") String name, Pageable pageable);


//    @Query(value = "select * from foods where id_cate= :id" , nativeQuery = true);
    Page<Foods> findAllByCategory(Category category, Pageable pageable);

}
