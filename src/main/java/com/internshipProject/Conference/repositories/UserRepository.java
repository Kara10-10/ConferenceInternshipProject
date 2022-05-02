package com.internshipProject.Conference.repositories;

import com.internshipProject.Conference.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail (String email);
}
