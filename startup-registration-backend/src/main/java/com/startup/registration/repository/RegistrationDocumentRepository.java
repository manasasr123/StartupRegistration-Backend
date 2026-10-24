
package com.startup.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.startup.registration.entity.RegistrationDocument;

@Repository
public interface RegistrationDocumentRepository
        extends JpaRepository<RegistrationDocument, Long> {

    List<RegistrationDocument> findByFounderId(Long founderId);
    
    List<RegistrationDocument> findByStartupDetailsId(Long startupDetailsId);
    
    List<RegistrationDocument> findByRegistrationKey(String registrationKey);
}
