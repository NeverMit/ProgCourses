package com.progcourses.progcourses.repositories.models;

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
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teacherName;
    private String title;
    private int price;
    private int timeOfStudying;
    private String description;
    public Course(String teacherName,String title,
                  int price,int timeOfStudying,
                  String description){
        this.teacherName=teacherName;
        this.title=title;
        this.price=price;
        this.timeOfStudying=timeOfStudying;
        this.description=description;
    }

    public void setAllFieldsExceptId(String title, String teacherName,
                                     int price, int timeOfStudying,
                                     String description){
        this.teacherName=teacherName;
        this.title=title;
        this.price=price;
        this.timeOfStudying=timeOfStudying;
        this.description=description;
    }
}
