package com.example.shiftscheduler.controller;

import com.example.shiftscheduler.entity.Shift;
import com.example.shiftscheduler.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {
    @Autowired
    private ShiftService shiftService;

    @GetMapping("/{date}")
    public List<Shift> getShiftsByDate(@PathVariable LocalDate date) {
        return shiftService.findByDate(date);
    }

    @PostMapping
    public Shift createShift(@RequestBody Shift shift) {
        return shiftService.saveShift(shift);
    }

    @PostMapping("/auto-generate")
    public void autoGenerateShifts(@RequestBody List<LocalDate> dates, @RequestBody List<Long> userIds) {
        shiftService.autoGenerateShifts(dates, userIds);
    }
}
