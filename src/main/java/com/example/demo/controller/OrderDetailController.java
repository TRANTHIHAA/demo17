package com.example.demo.controller;

import com.example.demo.model.OrderDetail;
import com.example.demo.model.Restaurants;
import com.example.demo.model.Roles;
import com.example.demo.service.IOrderDetailService;
import com.example.demo.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("orderdetail")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService iOrderDetailService;

    @GetMapping
    private ResponseEntity<Page<OrderDetail>> display(@PageableDefault(value = 5) Pageable pageable) {
        return new ResponseEntity<>(iOrderDetailService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<OrderDetail> create(@RequestBody OrderDetail orderDetail) {
        return new ResponseEntity<>(iOrderDetailService.save(orderDetail), HttpStatus.CREATED);
    }
}
