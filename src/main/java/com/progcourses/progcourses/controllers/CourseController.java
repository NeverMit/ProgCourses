package com.progcourses.progcourses.controllers;

import com.progcourses.progcourses.controllers.models.Course;
import com.progcourses.progcourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping("/courses")
    public String courses(Model model){
        Iterable<Course> courses=courseRepository.findAll();
        model.addAttribute("courses",courses);
        return "courses";
    }
    @GetMapping("/courses/{id}")
    public String showCourseDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Course> course=courseRepository.findById(id);
        List<Course> res=new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course",res);
        return "courseDetails";
    }
}
