
package com.startup.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.startup.registration.entity.Founder;
import com.startup.registration.entity.StartupDetails;

@Repository
public interface StartupDetailsRepository
        extends JpaRepository<StartupDetails, Long> {

    Optional<StartupDetails> findByFounder(Founder founder);
}
