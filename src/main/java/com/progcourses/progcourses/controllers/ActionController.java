package com.progcourses.progcourses.controllers;

import com.progcourses.progcourses.controllers.models.Course;
import com.progcourses.progcourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ActionController {
    @Autowired
    private CourseRepository courseRepository;
    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/action")
    public String courses(Model model){
        Iterable<Course> courses=courseRepository.findAll();
        model.addAttribute("courses",courses);
        return "action";
    }
    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/action/{id}")
    public String showActionsCourseDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Course> course=courseRepository.findById(id);
        List<Course> res=new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course",res);
        return "actionCourseDetails";
    }

}
