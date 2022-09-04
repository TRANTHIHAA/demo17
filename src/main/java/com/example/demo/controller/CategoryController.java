package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping
    private ResponseEntity<Page<Category>> display(@PageableDefault(value = 5) Pageable pageable){
        return new ResponseEntity<>(iCategoryService.findAll(pageable), HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<Category> createCatelogy(@RequestBody Category category){
        return new ResponseEntity<>(iCategoryService.save(category), HttpStatus.CREATED);
    }
}
