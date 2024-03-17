package com.api.user.services;

import com.api.user.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();

}
