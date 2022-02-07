package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userRepository.findById((long) id).get();
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userRepository.deleteById((long) id);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        userRepository.deleteById(Long.valueOf(id));
        userRepository.save(user);
    }
}
