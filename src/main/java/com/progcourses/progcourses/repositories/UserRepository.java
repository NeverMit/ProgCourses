package com.progcourses.progcourses.repositories;

import com.progcourses.progcourses.controllers.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
