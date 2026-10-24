
package com.startup.registration.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private final Path uploadDirectory =
            Paths.get("uploads", "startup-documents")
                 .toAbsolutePath()
                 .normalize();

    public FileStorageService() throws IOException {
        Files.createDirectories(uploadDirectory);
    }

    public String storeFile(MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Please select a file.");
        }

        String originalFilename =
                StringUtils.cleanPath(file.getOriginalFilename());

        if (originalFilename.contains("..")) {
            throw new IllegalArgumentException("Invalid file name.");
        }

        String extension = "";

        int dotIndex = originalFilename.lastIndexOf('.');
        if (dotIndex >= 0) {
            extension = originalFilename.substring(dotIndex);
        }

        String storedFilename = UUID.randomUUID() + extension;

        Path destination = uploadDirectory.resolve(storedFilename)
                                          .normalize();

        if (!destination.startsWith(uploadDirectory)) {
            throw new IllegalArgumentException("Invalid file path.");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(
                inputStream,
                destination,
                StandardCopyOption.REPLACE_EXISTING
            );
        }

        return storedFilename;
    }
}
