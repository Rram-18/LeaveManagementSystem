package com.ram.leave.service;

import com.ram.leave.model.Leave;
import com.ram.leave.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepo;

    @Autowired
    private EmailService emailService;

    public void applyLeave(Leave leave) {
        leave.setStatus("PENDING");
        leaveRepo.save(leave);
    }

    public List<Leave> getMyLeaves(String email) {
        return leaveRepo.findByEmail(email);
    }

    public List<Leave> getPendingLeaves() {
        return leaveRepo.findByStatus("PENDING");
    }

    public void approveLeave(Long id) {
        Leave leave = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found with ID: " + id));

        leave.setStatus("APPROVED");
        leaveRepo.save(leave);

        // Email content
        String subject = "Leave Approved";
        String body = "Hi, your leave from " + leave.getFromDate() + " to " + leave.getToDate() + " is approved.";

        // 🛡️ Wrap in try-catch to avoid breaking the whole API
        try {
            emailService.sendEmail(leave.getEmail(), subject, body);
        } catch (Exception e) {
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
