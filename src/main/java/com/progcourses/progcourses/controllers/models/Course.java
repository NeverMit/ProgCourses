package com.progcourses.progcourses.controllers.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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
    private String description;

    public Course(String title,String teacherName,int price,int timeOfStudying,String description) {
        this.teacherName = teacherName;
        this.title = title;
        this.price = price;
        this.timeOfStudying = timeOfStudying;
        this.description=description;
    }
    public Course() {}
    public void setAllFieldsExceptId(String title, String teacherName,int price,int timeOfStudying, String description){
        this.title=title;
        this.teacherName=teacherName;
        this.price=price;
        this.timeOfStudying=timeOfStudying;
        this.description=description;
    }
}
