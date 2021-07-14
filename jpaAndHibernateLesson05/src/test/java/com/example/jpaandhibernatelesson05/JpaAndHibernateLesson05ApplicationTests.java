package com.example.jpaandhibernatelesson05;

import com.example.jpaandhibernatelesson05.entity.Course;
import com.example.jpaandhibernatelesson05.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class JpaAndHibernateLesson05ApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    public void findById_basic() {
        Course course = repository.findById(1001L);

        assertEquals("JPA Course", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        repository.deleteById(1002L);
        assertNull(repository.findById(1002L));
    }

    @Test
    public void save_basic() {
        Course course = repository.findById(1001L);
        assertEquals("JPA Course", course.getName());
        course.setName("JPA Course Updated");
        repository.save(course);

        Course courseChanged = repository.findById(1001L);
        assertEquals("JPA Course Updated", courseChanged.getName());
    }

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        repository.playWithEntityManager();
    }

}
