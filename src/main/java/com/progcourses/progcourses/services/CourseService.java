package com.progcourses.progcourses.services;

import com.progcourses.progcourses.repositories.CourseRepository;
import com.progcourses.progcourses.repositories.models.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    protected final CourseRepository courseRepository;
    public List<Course> findAll(){
        return courseRepository.findAll();
    }
    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }
    public void delete(Course course){
        courseRepository.delete(course);
    }
    public Course save(Course course){
        return courseRepository.save(course);
    }
}
