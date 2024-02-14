package com.progcourses.progcourses.repositories;

import com.progcourses.progcourses.repositories.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
