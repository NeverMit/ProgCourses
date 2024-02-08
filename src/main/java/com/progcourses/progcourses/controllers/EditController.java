package com.progcourses.progcourses.controllers;

import com.progcourses.progcourses.controllers.models.Course;
import com.progcourses.progcourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EditController {
    @Autowired
    private CourseRepository courseRepository;
    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/action/{id}/edit")
    public String editCourse(@PathVariable(value = "id") Long id, Model model){
        Optional<Course> course=courseRepository.findById(id);
        List<Course> res=new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course",res);
        return "course-edit";
    }
    @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/action/{id}/edit")
    public String postEditCourse(@PathVariable(value = "id") Long id,
                                 @RequestParam String title,
                                 @RequestParam String teacherName,
                                 @RequestParam int price,
                                 @RequestParam int timeOfStudying,
                                 @RequestParam String description,
                                 Model model){
        Course course=courseRepository.findById(id).orElseThrow();
        course.setAllFieldsExceptId(title,teacherName,price,timeOfStudying,description);
        courseRepository.save(course);
        return "redirect:/action";
    }
}
