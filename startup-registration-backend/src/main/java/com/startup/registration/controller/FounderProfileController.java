
package com.startup.registration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startup.registration.dto.request.StartupDetailsRequest;
import com.startup.registration.service.FounderProfileService;

@RestController
@RequestMapping("/api/founder-profiles")
public class FounderProfileController {

    private final FounderProfileService founderProfileService;

    public FounderProfileController(
            FounderProfileService founderProfileService) {
        this.founderProfileService = founderProfileService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveFounderProfile(
            @RequestBody StartupDetailsRequest request) {

        founderProfileService.saveFounderProfile(request);

        return ResponseEntity.ok("Founder profile saved successfully");
    }
}
