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
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
class NativeQueryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_basic() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}",resultList);
    }


    @Test
    public void native_queries_with_parameters() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?", Course.class);
        query.setParameter(1, 1001L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE WHERE id = ? -> {}",resultList);
    }

    @Test
    public void native_queries_with_name_parameters() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id", Course.class);
        query.setParameter("id", 1001L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE WHERE id = :id -> {}",resultList);
    }


    @Test
    public void native_queries_to_update() {
        Query query = em.createNativeQuery("UPDATE COURSE SET last_updated_date=sysdate()");
        int numberOfRowsUpdated = query.executeUpdate();
        logger.info("numberOfRowsUpdated -> {}",numberOfRowsUpdated);
    }



}
