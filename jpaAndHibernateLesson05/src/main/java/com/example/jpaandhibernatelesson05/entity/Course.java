package com.example.jpaandhibernatelesson05.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
@NamedQueries( value = {
    @NamedQuery(name="query_get_all_courses", query = "Select c From Course c"),
    @NamedQuery(name="query_get_spring_courses", query = "Select c From Course c where c.name like '%Spring'")
})
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

    @UpdateTimestamp
    @Column(name="last_updated_date")
    private LocalDateTime lastUpdateDate;

    @CreationTimestamp
    @Column(name="created_date")
    private LocalDateTime createDate;

}
