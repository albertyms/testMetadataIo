package com.metadata.test.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "courses", schema="metadataio")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name_course")
    private String nameCourse;
    @Column(name = "code_course")
    private String codeCourse;
    @Column(name = "number_student")
    private Integer numberStudent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return id != null && Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
