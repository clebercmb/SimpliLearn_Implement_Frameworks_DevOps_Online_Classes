package com.example.jpaandhibernatelesson05;

import com.example.jpaandhibernatelesson05.entity.*;
import com.example.jpaandhibernatelesson05.repository.CourseRepository;
import com.example.jpaandhibernatelesson05.repository.EmployeeRepository;
import com.example.jpaandhibernatelesson05.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //courseRepository.playWithEntityManager();
        //studentRepository.saveStudentWithPassport();

        //courseRepository.addHardCodedReviewsForCourse();

        //Set<Review> reviews = new HashSet<>();
        //reviews.add(Review.builder().rating("4").description("Greats Hands-off").build());
        //reviews.add(Review.builder().rating("5").description("Hats off").build());
        //courseRepository.addReviewsForCourse(1003L, reviews);

        //studentRepository.insertHardCodedStudentAndCourse();

        //Student student = new Student();
        //student.setName("Thanos");

        //Course course = new Course();
        //course.setName("Microservices");

        //studentRepository.insertCodedStudentAndCourse(student, course);



        employeeRepository.insert(new PartTimeEmployee("Jack", new BigDecimal("10000")));
        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

        //logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());

        logger.info("All FullTimeEmployees -> {}", employeeRepository.retrieveAllFullTimeEmployees());

        logger.info("All PartTimeEmployees -> {}", employeeRepository.retrieveAllPartTimeEmployees());

    }

}
