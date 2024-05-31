package com.example.shiftscheduler.repository;

import com.example.shiftscheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
