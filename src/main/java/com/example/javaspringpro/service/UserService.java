package com.example.javaspringpro.service;

import com.example.javaspringpro.model.User;
import com.example.javaspringpro.repository.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User insert(String userName) {
        return userDao.insert(userName);
    }
    public void delete(User user) {
        userDao.deleteById(user.getId());
    }

    public User findById(Long id) {
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void deleteAll() {
        userDao.deleteAll();
    }
}
