package com.example.jpaandhibernatelesson05;

import com.example.jpaandhibernatelesson05.entity.Course;
import com.example.jpaandhibernatelesson05.repository.CourseRepository;
import com.example.jpaandhibernatelesson05.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

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

}
