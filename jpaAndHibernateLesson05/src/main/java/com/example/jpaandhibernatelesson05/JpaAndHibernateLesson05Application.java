package com.example.jpaandhibernatelesson05;

import com.example.jpaandhibernatelesson05.entity.Course;
import com.example.jpaandhibernatelesson05.entity.Student;
import com.example.jpaandhibernatelesson05.repository.CourseRepository;
import com.example.jpaandhibernatelesson05.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAndHibernateLesson05Application implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaAndHibernateLesson05Application.class, args);
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

        Student student = new Student();
        student.setName("Thanos");

        Course course = new Course();
        course.setName("Microservices");

        studentRepository.insertCodedStudentAndCourse(student, course);
    }

}
