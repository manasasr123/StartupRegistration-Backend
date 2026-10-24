package com.startup.registration.service;

import com.startup.registration.entity.Founder;

public interface FounderService {

    Founder registerFounder(Founder founder);

    boolean emailExists(String email);
}