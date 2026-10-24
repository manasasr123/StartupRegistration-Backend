
package com.startup.registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.startup.registration.dto.request.FounderRegistrationRequest;
import com.startup.registration.dto.response.FounderRegistrationResponse;
import com.startup.registration.entity.Founder;
import com.startup.registration.service.FounderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/founders")
public class FounderController {

    private final FounderService founderService;

    public FounderController(FounderService founderService) {
        this.founderService = founderService;
    }

    @PostMapping("/register")
    public ResponseEntity<FounderRegistrationResponse> registerFounder(
            @Valid @RequestBody FounderRegistrationRequest request) {

    	Founder founder = new Founder(
    	        request.getFullName(),
    	        request.getEmail(),
    	        request.getMobile()
    	);

    	founder.setPassword(request.getPassword());

        Founder savedFounder = founderService.registerFounder(founder);

        FounderRegistrationResponse response =
                new FounderRegistrationResponse(
                        savedFounder.getId(),
                        savedFounder.getFullName(),
                        savedFounder.getEmail(),
                        "Founder registered successfully"
                );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        return ResponseEntity.ok(founderService.emailExists(email));
    }
    

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Startup Registration Backend is running!");
    }

}
