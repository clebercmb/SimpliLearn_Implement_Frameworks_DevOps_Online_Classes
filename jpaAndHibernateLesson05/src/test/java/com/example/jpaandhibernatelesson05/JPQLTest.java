package com.example.jpaandhibernatelesson05;

import com.example.jpaandhibernatelesson05.entity.Course;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

@SpringBootTest
class JPQLTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void findById_basic() {
        Query query = em.createQuery("Select c From Course c");
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}",resultList);
    }

    @Test
    public void findById_basic_typed() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}",resultList);

    }

    @Test
    public void find_using_name_query_basic() {
        Query query = em.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}",resultList);

    }


    @Test
    public void find_using_name_query2_basic() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_spring_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}",resultList);

    }

}
