package com.example.demo.controllers;

import com.example.demo.models.Applications;
import com.example.demo.services.AppService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/apps")
@AllArgsConstructor
public class AppController {
    private AppService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the app!";
    }

    @GetMapping("/all-app")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Applications> allApp() {
        return service.allApplications();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Applications appById(@PathVariable int id) {
        return service.applicationById(id);
    }
}
