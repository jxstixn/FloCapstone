package com.florian.demo.service;

import com.florian.demo.model.User;
import com.florian.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> findUsers() {
        return userRepo.findAll();
    }

    public Optional<User> fetchUser(int id) {
        return userRepo.findById(id);
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public boolean deleteUser(int id) {
        boolean status;
        try {
            userRepo.deleteById(id);
            status = true;
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
}