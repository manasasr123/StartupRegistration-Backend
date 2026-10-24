
package com.startup.registration.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.startup.registration.entity.Founder;
import com.startup.registration.repository.FounderRepository;
import com.startup.registration.service.FounderService;

@Service
public class FounderServiceImpl implements FounderService {

    private final FounderRepository founderRepository;
    private final PasswordEncoder passwordEncoder;

    public FounderServiceImpl(
            FounderRepository founderRepository,
            PasswordEncoder passwordEncoder) {
        this.founderRepository = founderRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Founder registerFounder(Founder founder) {
        if (founderRepository.existsByEmail(founder.getEmail())) {
            throw new IllegalArgumentException(
                    "A founder with this email already exists.");
        }

        if (founder.getPassword() == null
                || founder.getPassword().isBlank()) {
            throw new IllegalArgumentException(
                    "Password is required.");
        }

        founder.setPassword(
                passwordEncoder.encode(founder.getPassword()));

        return founderRepository.save(founder);
    }

    @Override
    public boolean emailExists(String email) {
        return founderRepository.existsByEmail(email);
    }
}
