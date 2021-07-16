package com.example.jpaandhibernatelesson05.repository;


import com.example.jpaandhibernatelesson05.entity.Passport;
import com.example.jpaandhibernatelesson05.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student) {
        if(student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
        return student;
    }

    // TODO
    public void saveStudentWithPassport() {
        Passport passport = Passport.builder().number("Z123456").build();
        em.persist(passport);

        Student student = Student.builder().name("Doctor Stranger").passport(passport).build();
        em.persist(student);

    }

    public void someDummyOperation() {
        //Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 2001L);
        // Persistence Context (student)

        //Database Operation 2 - retrieve passport
        Passport passport = student.getPassport();
        // Persistence Context (student, passport)

        //Database Operation 3 - upddate passport
        passport.setNumber("E1234567");
        // Persistence Context (student, passport++)

        //Database Operation 4 - update student
        student.setName("Hulk - Updated");
        // Persistence Context (student++, passport++)
    }
}
