package com.example.masterhibernateandjpalesson03;

import com.example.masterhibernateandjpalesson03.entity.Person;

import com.example.masterhibernateandjpalesson03.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MasterHibernateAndJpaLesson03Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MasterHibernateAndJpaLesson03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Person p = Person.builder().id(10).build();
        Person p2 = new Person();

        logger.info("User id 1001 ->{}", repository.findById(1001));

        logger.info("Inserting 1005 -> {}", repository.insert(Person.builder()
                .name("Steve Rogers")
                .location("New York")
                .birthDate(new Date())
                .build()));

        logger.info("Update 1003 -> {}", repository.update(
                Person.builder()
                        .id(1003)
                        .name("Thor Ragnarok")
                        .location("Asgard")
                        .birthDate(new Date())
                        .build()
        ));

        repository.deleteById(1002);

    }
}
