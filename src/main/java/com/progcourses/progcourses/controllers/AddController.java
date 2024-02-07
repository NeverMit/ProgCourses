package com.progcourses.progcourses.controllers;

import com.progcourses.progcourses.controllers.models.Course;
import com.progcourses.progcourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping("/add")
    public String addCourse(Model model){
        return "add";
    }
    @PostMapping("/add")
    public String addPostCourse(@RequestParam String title,
                                @RequestParam String teacherName,
                                @RequestParam int price,
                                @RequestParam int timeOfStudying,
                                Model model){
        Course course=new Course(title,teacherName,price,timeOfStudying);
        courseRepository.save(course);
        return "redirect:/courses";
    }
}
