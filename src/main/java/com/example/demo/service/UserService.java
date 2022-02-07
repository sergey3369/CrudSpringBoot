package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    void update(int id, User user);
}
