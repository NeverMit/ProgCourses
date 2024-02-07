package com.progcourses.progcourses.controllers.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teacherName;
    private String title;
    private int price;
    private int timeOfStudying;

    public Course(String title,String teacherName,int price,int timeOfStudying) {
        this.teacherName = teacherName;
        this.title = title;
        this.price = price;
        this.timeOfStudying = timeOfStudying;
    }

    public Course() {

    }
}
