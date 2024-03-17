package com.api.user.services.impl;

import com.api.user.domain.User;
import com.api.user.repositories.UserRepository;
import com.api.user.services.UserService;
import com.api.user.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private final UserRepository respository;

    @Override
    public User findById(Long id) {
        return  respository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not found"));
    }

    @Override
    public List<User> findAll() {
        return respository.findAll();
    }
}
