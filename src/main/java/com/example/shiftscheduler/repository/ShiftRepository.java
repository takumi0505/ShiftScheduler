package com.example.shiftscheduler.repository;

import com.example.shiftscheduler.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    List<Shift> findByDate(LocalDate date);
}
