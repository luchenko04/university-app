package com.example.universityapp.controller;

import com.example.universityapp.dto.AuthRequest;
import com.example.universityapp.dto.AuthResponse;
import com.example.universityapp.entity.AppUser;
import com.example.universityapp.security.JwtUtil;
import com.example.universityapp.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AppUserService appUserService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AppUserService appUserService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.appUserService = appUserService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        logger.debug("Registering user: {}", request.getUsername());
        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        appUserService.save(user);
        logger.info("User {} registered successfully", request.getUsername());
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        logger.debug("Attempting login for user: {}", request.getUsername());
        try {
            UserDetails userDetails = appUserService.loadUserByUsername(request.getUsername());
            logger.debug("Loaded user: {}, password hash: {}", userDetails.getUsername(), userDetails.getPassword());
            if (passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
                String token = jwtUtil.generateToken(userDetails.getUsername());
                logger.info("Login successful for user: {}", request.getUsername());
                return ResponseEntity.ok(new AuthResponse(token));
            } else {
                logger.warn("Password mismatch for user: {}", request.getUsername());
                return ResponseEntity.status(401).body(new AuthResponse("Invalid password"));
            }
        } catch (UsernameNotFoundException e) {
            logger.warn("User not found: {}", request.getUsername());
            return ResponseEntity.status(401).body(new AuthResponse("User not found"));
        } catch (Exception e) {
            logger.error("Login error for user: {}", request.getUsername(), e);
            return ResponseEntity.status(401).body(new AuthResponse("Login error"));
        }
    }
}