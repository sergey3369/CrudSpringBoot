package com.example.demo.service;

import com.example.demo.dao.Dao;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Dao dao;

    public UserServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return dao.getUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return dao.getUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        dao.deleteUser(id);
    }

    @Transactional
    @Override
    public void update(User user) { dao.update(user); }
}
