package com.progcourses.progcourses.controllers;

import com.progcourses.progcourses.controllers.models.Course;
import com.progcourses.progcourses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeleteController {
    @Autowired
    private CourseRepository courseRepository;
    @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/action/{id}/delete")
    public String deleteCourse(@PathVariable(value = "id")Long id, Model model){
        Course course=courseRepository.findById(id).orElseThrow();
        courseRepository.delete(course);
        return "redirect:/action";
    }
}
