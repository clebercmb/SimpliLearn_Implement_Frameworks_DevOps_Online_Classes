package com.example.jpaandhibernatelesson05.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor

public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    @Column(name="description")
    private String description;

}
