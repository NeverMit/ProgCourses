package com.progcourses.progcourses.controllers;

import com.progcourses.progcourses.repositories.CourseRepository;
import com.progcourses.progcourses.repositories.models.Course;
import com.progcourses.progcourses.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class CourseController {
   private final CourseService courseService;


    @GetMapping("/courses")
    public String courses(Model model){
        Iterable<Course> courses=courseService.findAll();
        model.addAttribute("courses",courses);
        return "courses";
    }
    @GetMapping("/courses/{id}")
    public String showCourseDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Course> course=courseService.findById(id);
        List<Course> res=new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course",res);
        return "courseDetails";
    }

}
