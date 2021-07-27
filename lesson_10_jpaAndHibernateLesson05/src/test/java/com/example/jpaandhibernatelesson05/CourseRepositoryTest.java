package com.example.jpaandhibernatelesson05;

import com.example.jpaandhibernatelesson05.entity.Course;
import com.example.jpaandhibernatelesson05.entity.Review;
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

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EntityManager em;


    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findById_basic() {
        Course course = courseRepository.findById(1001L);

        assertEquals("JPA Course", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        courseRepository.deleteById(1002L);
        assertNull(courseRepository.findById(1002L));
    }

    @Test
    public void save_basic() {
        Course course = courseRepository.findById(1001L);
        assertEquals("JPA Course", course.getName());
        course.setName("JPA Course Updated");
        courseRepository.save(course);

        Course courseChanged = courseRepository.findById(1001L);
        assertEquals("JPA Course Updated", courseChanged.getName());

    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        courseRepository.playWithEntityManager();
    }


    @Test
    @DirtiesContext
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = courseRepository.findById(1001L);
        logger.info("course.getReviews -> {}", course.getReviews());


    }

    @Test
    @DirtiesContext
    @Transactional
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class, 5001L);
        logger.info("review.getCourse() -> {}", review.getCourse());


    }

}
