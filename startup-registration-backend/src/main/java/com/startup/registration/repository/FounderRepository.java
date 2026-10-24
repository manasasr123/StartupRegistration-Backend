
package com.startup.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startup.registration.entity.Founder;

public interface FounderRepository extends JpaRepository<Founder, Long> {

    boolean existsByEmail(String email);

    Optional<Founder> findByEmail(String email);
}
