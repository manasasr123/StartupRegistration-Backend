
package com.startup.registration.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.startup.registration.entity.Founder;
import com.startup.registration.entity.RegistrationDocument;
import com.startup.registration.repository.FounderRepository;
import com.startup.registration.repository.RegistrationDocumentRepository;
import com.startup.registration.service.RegistrationDocumentService;

@Service
public class RegistrationDocumentServiceImpl
        implements RegistrationDocumentService {

    private final FounderRepository founderRepository;
    private final RegistrationDocumentRepository documentRepository;

    private final Path uploadDirectory =
            Paths.get("uploads", "startup-documents")
                    .toAbsolutePath().normalize();

    public RegistrationDocumentServiceImpl(
            FounderRepository founderRepository,
            RegistrationDocumentRepository documentRepository) {
        this.founderRepository = founderRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    @Transactional
    public void saveDocument(
            Long founderId,
            String registrationKey,
            String documentType,
            MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Please select a file");
        }

        if (registrationKey == null || registrationKey.isBlank()) {
            throw new IllegalArgumentException(
                    "Registration key is required");
        }

        Founder founder = founderRepository.findById(founderId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Founder not found"));

        Files.createDirectories(uploadDirectory);

        String originalFilename = Path.of(
                file.getOriginalFilename() == null
                        ? "document"
                        : file.getOriginalFilename())
                .getFileName().toString();

        String storedFilename =
                UUID.randomUUID() + "_" + originalFilename;

        Path destination = uploadDirectory.resolve(storedFilename)
                .normalize();

        if (!destination.startsWith(uploadDirectory)) {
            throw new IllegalArgumentException("Invalid filename");
        }

        file.transferTo(destination);

        RegistrationDocument document = new RegistrationDocument();
        document.setFounderId(founder.getId());
        document.setRegistrationKey(registrationKey);
        document.setDocumentType(documentType);
        document.setOriginalFilename(originalFilename);
        document.setStoredFilename(storedFilename);
        document.setFilePath(destination.toString());

        documentRepository.save(document);
    }

    @Override
    public List<RegistrationDocument> getDocumentsByFounderId(
            Long founderId) {
        return documentRepository.findByFounderId(founderId);
    }

    @Override
    public List<RegistrationDocument> getDocumentsByRegistrationKey(
            String registrationKey) {
        return documentRepository.findByRegistrationKey(registrationKey);
    }
}
