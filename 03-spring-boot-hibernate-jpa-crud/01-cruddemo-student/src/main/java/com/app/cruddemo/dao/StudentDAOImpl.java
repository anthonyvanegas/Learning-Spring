package com.app.cruddemo.dao;

import org.springframework.stereotype.Repository;

import com.app.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Define field for entity manager.
    private EntityManager entityManager;

    // Inject entity manager using constructor injection.
    public StudentDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    // Implement save() method.
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

}
