
package com.startup.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.startup.registration.entity.Founder;
import com.startup.registration.entity.FounderProfile;

@Repository
public interface FounderProfileRepository
        extends JpaRepository<FounderProfile, Long> {

    Optional<FounderProfile> findByFounder(Founder founder);
}
