package com.example.spring.data.access.dao.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="stocks")
public class Stock implements Serializable {

    @Id
    private String id;
    private String name;
    private Double price;

}
