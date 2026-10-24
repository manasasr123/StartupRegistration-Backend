package com.startup.registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startup.registration.dto.request.StartupDetailsRequest;
import com.startup.registration.service.StartupDetailsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.startup.registration.entity.Founder;
import com.startup.registration.repository.FounderRepository;

@RestController
@RequestMapping("/api/startups")
public class StartupDetailsController {

    private final StartupDetailsService startupDetailsService;
    private final FounderRepository founderRepository;

    public StartupDetailsController(
            StartupDetailsService startupDetailsService,
            FounderRepository founderRepository) {
        this.startupDetailsService = startupDetailsService;
        this.founderRepository = founderRepository;
    }
    
    @GetMapping("/founder")
    public ResponseEntity<?> getFounderByEmail(
            @RequestParam String email) {

        return founderRepository.findByEmail(email)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Founder not found"));
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveStartupDetails(
            @RequestBody StartupDetailsRequest request) {

        startupDetailsService.saveStartupDetails(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Startup details saved successfully");
    }
}