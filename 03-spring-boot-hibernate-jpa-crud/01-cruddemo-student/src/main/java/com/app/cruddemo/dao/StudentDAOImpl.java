package com.app.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    // Implement findById() method.
    @Override
    public Student findById(int theId) {
        return entityManager.find(Student.class, theId);
    }

    @Override
    public List<Student> findAll() {
        // Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        
        // Return Query Results
        return theQuery.getResultList();
    
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // Create Query.
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);
        // Set query parameters.
        theQuery.setParameter("theData", theLastName);

        // Return query results.
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // Retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // Delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }

}
