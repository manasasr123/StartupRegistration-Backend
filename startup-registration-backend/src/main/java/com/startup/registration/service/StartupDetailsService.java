package com.startup.registration.service;

import com.startup.registration.dto.request.StartupDetailsRequest;

public interface StartupDetailsService {

    void saveStartupDetails(StartupDetailsRequest request);

}