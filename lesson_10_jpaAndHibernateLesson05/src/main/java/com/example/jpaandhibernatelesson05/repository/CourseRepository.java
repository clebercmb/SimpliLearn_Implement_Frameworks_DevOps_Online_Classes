package com.example.jpaandhibernatelesson05.repository;


import com.example.jpaandhibernatelesson05.entity.Course;
import com.example.jpaandhibernatelesson05.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CourseRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if(course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    // TODO
    public void playWithEntityManager() {
        Course course = Course.builder().name("Web Services").build();
        em.persist(course);
        course.setName("Web Services Updated");

    }

    public void addHardCodedReviewsForCourse() {
        //get Course 1003
        //add 2 reviews to it
        //save it to the database
        Course course = em.find(Course.class, 1003L);
        logger.info("course.getReviews() -> {}",course.getReviews());

        //add 2 reviews
        Review review1 = Review.builder().rating("4").description("Greats Hands-off").build();
        Review review2 = Review.builder().rating("5").description("Hats off").build();

        //setting the relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        //save it to the database
        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, Set<Review> reviews) {
        Course course = em.find(Course.class, courseId);
        logger.info("course.getReviews() -> {}",course.getReviews());

        for(Review review: reviews) {
            //setting up the relationship
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }


}
