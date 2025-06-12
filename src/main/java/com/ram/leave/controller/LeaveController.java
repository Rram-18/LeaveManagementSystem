package com.ram.leave.controller;

import com.ram.leave.model.Leave;
import com.ram.leave.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/apply")
    public String apply(@RequestBody Leave leave) {
        leaveService.applyLeave(leave);
        return "Leave Applied";
    }

    @PostMapping("/approve/{id}")
    public String approve(@PathVariable Long id) {
        leaveService.approveLeave(id);
        return "Leave Approved";
    }

    @GetMapping("/mine")
    public List<Leave> myLeaves(@RequestParam String email) {
        return leaveService.getMyLeaves(email);
    }

    @GetMapping("/pending")
    public List<Leave> pending() {
        return leaveService.getPendingLeaves();
    }
}