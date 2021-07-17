package com.example.jpaandhibernatelesson05.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne
    private Course course;


    @Override
    public String toString() {
        return "Review{" +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
