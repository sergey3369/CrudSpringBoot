package com.example.demo.dao;

import com.example.demo.model.User;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DaoImpl implements Dao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        Query query = entityManager.
                createQuery("SELECT e FROM User e");
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        Query query = entityManager.
                createQuery("select u from User u where u.id = :id");
        query.setParameter("id", (long) id);
        return (User) query.getSingleResult();
    }

    @Override
    public void deleteUser(Integer id) {
        Query query = entityManager.
                createQuery("delete from User u where u.id = :id");
        query.setParameter("id", (long) id);
        query.executeUpdate();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
