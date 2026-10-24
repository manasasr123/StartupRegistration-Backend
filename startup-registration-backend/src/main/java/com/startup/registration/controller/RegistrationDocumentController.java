
package com.startup.registration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.startup.registration.service.RegistrationDocumentService;

@RestController
@RequestMapping("/api/registration-documents")
@CrossOrigin(origins = "http://localhost:5173")
public class RegistrationDocumentController {

    private final RegistrationDocumentService documentService;

    public RegistrationDocumentController(
            RegistrationDocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(
            @RequestParam Long founderId,
            @RequestParam String registrationKey,
            @RequestParam String documentType,
            @RequestParam MultipartFile file) throws Exception {

        documentService.saveDocument(
                founderId, registrationKey, documentType, file);

        return ResponseEntity.ok("Document uploaded successfully");
    }

    @GetMapping("/founder/{founderId}")
    public ResponseEntity<?> getDocumentsByFounder(
            @PathVariable Long founderId) {
        return ResponseEntity.ok(
                documentService.getDocumentsByFounderId(founderId));
    }

    @GetMapping("/registration/{registrationKey}")
    public ResponseEntity<?> getDocumentsByRegistration(
            @PathVariable String registrationKey) {
        return ResponseEntity.ok(
                documentService.getDocumentsByRegistrationKey(registrationKey));
    }
}
