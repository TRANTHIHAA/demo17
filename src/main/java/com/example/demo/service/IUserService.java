package com.example.demo.service;

import com.example.demo.common.IGeneral;
import com.example.demo.model.Users;

public interface IUserService extends IGeneral<Users> {
    Users findByEmail(String email);

    boolean checkRegexPassword(String password);
}
