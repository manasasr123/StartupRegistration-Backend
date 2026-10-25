package com.startup.registration.service;

import java.util.Optional;

import com.startup.registration.dto.request.StartupDetailsRequest;
import com.startup.registration.entity.Founder;
import com.startup.registration.entity.StartupDetails;

public interface StartupDetailsService {

    void saveStartupDetails(StartupDetailsRequest request);

    Optional<StartupDetails> getStartupDetails(Founder founder);
}