package com.example.jpaandhibernatelesson05;

import com.example.jpaandhibernatelesson05.entity.Course;
import com.example.jpaandhibernatelesson05.entity.Passport;
import com.example.jpaandhibernatelesson05.entity.Student;
import com.example.jpaandhibernatelesson05.repository.CourseRepository;
import com.example.jpaandhibernatelesson05.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
class StudentRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 2001L);

        logger.info("student -> {}", student);
        logger.info("student.getPassport() -> {}", student.getPassport());
    }

    //Session & Session Factory
    //EntityManager & Persistence Context
    //Transaction

    @Test
    @Transactional
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

    @Test
    public void someTest() {
        studentRepository.someDummyOperation();
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 4001L);
        logger.info("passport -> {}", passport.getNumber());
        logger.info("student -> {}", passport.getStudent().getName());
    }

}
