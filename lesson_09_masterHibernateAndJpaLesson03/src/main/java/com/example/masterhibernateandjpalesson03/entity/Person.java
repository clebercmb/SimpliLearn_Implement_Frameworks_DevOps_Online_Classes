package com.example.masterhibernateandjpalesson03.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String location;

    @Column(name = "birth_date")
    private Date birthDate;

}
