package com.ram.leave.controller;

import com.ram.leave.dto.LoginRequest;
import com.ram.leave.model.User;
import com.ram.leave.repository.UserRepository;
import com.ram.leave.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + req.getEmail()));



        if (!user.getPassword().equals(req.getPassword())) {
            return ResponseEntity.status(401).body("Wrong password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok("Bearer " + token);
    }
}