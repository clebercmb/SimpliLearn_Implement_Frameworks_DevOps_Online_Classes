package com.example.jpaandhibernatelesson05.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
@NamedQueries( value = {
    @NamedQuery(name="query_get_all_courses", query = "Select c From Course c"),
    @NamedQuery(name="query_get_spring_courses", query = "Select c From Course c where c.name like '%Spring'")
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
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

    // Review is the owning side of the relationship
    @OneToMany (mappedBy = "course")
    @Setter(AccessLevel.NONE)
    private Set<Review> reviews = new HashSet<>();

    //mappedBy makes Student the owner of the relationship
    @ManyToMany(mappedBy = "courses")
    @Setter(AccessLevel.NONE)
    private Set<Student> students = new HashSet<>();


    public void addReview(Review review) {
        this.reviews.add(review);

    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", createDate=" + createDate +
                '}';
    }
}
