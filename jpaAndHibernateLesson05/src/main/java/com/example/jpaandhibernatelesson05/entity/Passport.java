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

public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="number", nullable = false)
    private String number;

    // mappedBy makes Student the owning side of the relationship
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

}
