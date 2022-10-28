package com.vietez.studentservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private boolean active;
    private int grade;

    public Student(Long id, String name) {
        Id = id;
        this.name = name;
    }
}
