package com.example.shiftscheduler.service;

import com.example.shiftscheduler.entity.Shift;
import com.example.shiftscheduler.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;

    public List<Shift> findByDate(LocalDate date) {
        return shiftRepository.findByDate(date);
    }

    public Shift saveShift(Shift shift) {
        return shiftRepository.save(shift);
    }

    public void autoGenerateShifts(List<LocalDate> dates, List<Long> userIds) {
        Random random = new Random();
        for (LocalDate date : dates) {
            for (int i = 0; i < 2; i++) {
                if (!userIds.isEmpty()) {
                    Long userId = userIds.remove(random.nextInt(userIds.size()));
                    Shift shift = new Shift();
                    shift.setDate(date);
                    shift.setUserId(userId);
                    shiftRepository.save(shift);
                }
            }
        }
    }
}
