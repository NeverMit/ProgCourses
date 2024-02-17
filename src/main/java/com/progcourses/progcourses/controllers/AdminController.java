package com.progcourses.progcourses.controllers;

import com.progcourses.progcourses.repositories.models.Course;
import com.progcourses.progcourses.services.CourseService;
import com.progcourses.progcourses.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private final CourseService courseService;
    @GetMapping("/admin/add")
    public String addCourse(){
        return "add";
    }
    @PostMapping("/admin/add/post")
    public String addPostCourse(@RequestParam String title,
                                @RequestParam String teacherName,
                                @RequestParam int price,
                                @RequestParam int timeOfStudying,
                                @RequestParam String description
    ){
        Course course=new Course(title,teacherName,price,timeOfStudying,description);
        courseService.save(course);
        return "redirect:/admin/action";
    }
    @GetMapping("/admin/action")
    public String actionCourses(Model model){
        Iterable<Course> courses=courseService.findAll();
        model.addAttribute("courses",courses);
        return "admin";
    }
    @GetMapping("/admin/action/{id}")
    public String showActionsCourseDetails(@PathVariable(value = "id") Long id, Model model){
        Optional<Course> course=courseService.findById(id);
        List<Course> res=new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course",res);
        return "adminCourseDetails";
    }
    @PostMapping("/admin/action/{id}/delete")
    public String deleteCourse(@PathVariable(value = "id")Long id){
        Course course=courseService.findById(id).orElseThrow();
        courseService.delete(course);
        return "redirect:/admin/action";
    }
    @GetMapping("/admin/action/{id}/edit")
    public String editCourse(@PathVariable(value = "id") Long id, Model model){
        Optional<Course> course=courseService.findById(id);
        List<Course> res=new ArrayList<>();
        course.ifPresent(res::add);
        model.addAttribute("course",res);
        return "course-edit";
    }
    @PostMapping("/admin/action/{id}/edit")
    public String postEditCourse(@PathVariable(value = "id") Long id,
                                 @RequestParam String title,
                                 @RequestParam String teacherName,
                                 @RequestParam int price,
                                 @RequestParam int timeOfStudying,
                                 @RequestParam String description){
        Course course=courseService.findById(id).orElseThrow();
        course.setAllFieldsExceptId(title,teacherName,price,timeOfStudying,description);
        courseService.save(course);
        return "redirect:/admin/action";
    }
}
