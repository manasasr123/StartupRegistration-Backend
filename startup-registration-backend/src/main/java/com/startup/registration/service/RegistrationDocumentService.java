
package com.startup.registration.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.startup.registration.entity.RegistrationDocument;

public interface RegistrationDocumentService {

    void saveDocument(
        Long founderId,
        String registrationKey,
        String documentType,
        MultipartFile file
    ) throws Exception;

    List<RegistrationDocument> getDocumentsByFounderId(Long founderId);

    List<RegistrationDocument> getDocumentsByRegistrationKey(
        String registrationKey
    );
}
