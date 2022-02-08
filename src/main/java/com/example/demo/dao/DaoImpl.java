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
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    @Override
    public List<User> getUsers() {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        Query query = entityManager.
                createQuery("SELECT e FROM User e");
        List<User> list = query.getResultList();
        return list;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(user);
        entityManager.close();
        entityTransaction.commit();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query query = entityManager.
                createQuery("select u from User u where u.id = :id");
        query.setParameter("id", (long) id);
        entityTransaction.commit();
        return (User) query.getSingleResult();
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query query = entityManager.
                createQuery("delete from User u where u.id = :id");
        query.setParameter("id", (long) id);
        query.executeUpdate();
        entityManager.close();
        entityTransaction.commit();
    }

    @Transactional
    @Override
    public void update(User user) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(user);
        entityManager.close();
        entityTransaction.commit();
    }
}
