package com.example.universityapp.controller;

import com.example.universityapp.dto.AuthRequest;
import com.example.universityapp.service.AppUserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthFormController {
    private final AppUserService appUserService;

    public AuthFormController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        model.addAttribute("authRequest", new AuthRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(AuthRequest request) {
        appUserService.register(request.getUsername(), request.getPassword());
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/home")
    public String showHomePage(Model model, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }
        model.addAttribute("username", authentication.getName());
        return "home";
    }
}