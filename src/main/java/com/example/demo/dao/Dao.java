package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface Dao {
    public List<User> getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(Integer id);

    void update(User user);
}
