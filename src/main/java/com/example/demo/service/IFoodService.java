package com.example.demo.service;

import com.example.demo.common.IGeneral;
import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFoodService extends IGeneral<Foods> {
    Page<Foods> findFoodByCategoryContaining (String name, Pageable pageable);
    Page<Foods> findAllByCategory(Category category, Pageable pageable);
}
