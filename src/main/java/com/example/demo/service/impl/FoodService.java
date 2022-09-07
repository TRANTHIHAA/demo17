package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import com.example.demo.repository.IFoodRepository;
import com.example.demo.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private IFoodRepository foodRepository;

//    @Override
//    public Page<Foods> findAll(Pageable pageable) {
//        return foodRepository.findAll(pageable);
//    }

    @Override
    public List<Foods> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Foods> findById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public Foods save(Foods t) {
        return foodRepository.save(t);
    }

    @Override
    public void removeById(Long id) {
        foodRepository.deleteById(id);
    }
    @Override
    public Page<Foods> findAllByNameContaining(Pageable pageable, String name) {
        return foodRepository.findAllByNameContaining(pageable,"%" + name + "%");
    }

    @Override
    public Page<Foods> findFoodByCategoryContaining(String name, Pageable pageable) {
        return foodRepository.findFoodByCategoryContaining("%" + name + "%", pageable);
    }



    @Override
    public Page<Foods> findAllByCategory(Category category, Pageable pageable) {
        return foodRepository.findAllByCategory(category,pageable);
    }
}
