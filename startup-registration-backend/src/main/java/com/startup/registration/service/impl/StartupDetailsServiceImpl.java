package com.startup.registration.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.startup.registration.dto.request.StartupDetailsRequest;
import com.startup.registration.entity.Founder;
import com.startup.registration.entity.StartupDetails;
import com.startup.registration.repository.FounderRepository;
import com.startup.registration.repository.StartupDetailsRepository;
import com.startup.registration.service.StartupDetailsService;

@Service
public class StartupDetailsServiceImpl implements StartupDetailsService {

    private final StartupDetailsRepository startupDetailsRepository;
    private final FounderRepository founderRepository;

    public StartupDetailsServiceImpl(
            StartupDetailsRepository startupDetailsRepository,
            FounderRepository founderRepository) {
        this.startupDetailsRepository = startupDetailsRepository;
        this.founderRepository = founderRepository;
    }

    @Override
    public void saveStartupDetails(StartupDetailsRequest request) {

        Founder founder = founderRepository.findById(request.getFounderId())
                .orElseThrow(() ->
                        new RuntimeException("Founder not found with ID: "
                                + request.getFounderId()));

        StartupDetails details = startupDetailsRepository
                .findByFounder(founder)
                .orElseGet(StartupDetails::new);

        details.setFounder(founder);
        details.setStartupName(request.getStartupName());
        details.setTagline(request.getTagline());
        details.setWebsite(request.getWebsite());
        details.setStartupEmail(request.getStartupEmail());
        details.setStartupMobile(request.getStartupMobile());

        details.setIndustry(request.getIndustry());
        details.setStartupStage(request.getStartupStage());

        details.setCompanyType(request.getCompanyType());
        details.setIncorporationStatus(request.getIncorporationStatus());
        details.setIncorporationDate(request.getIncorporationDate());
        details.setCin(request.getCin());
        details.setGstNumber(request.getGstNumber());
        details.setStartupIndia(request.getStartupIndia());
        details.setDpiitNumber(request.getDpiitNumber());

        details.setCountry(request.getCountry());
        details.setState(request.getState());
        details.setCity(request.getCity());
        details.setAddress(request.getAddress());
        details.setPinCode(request.getPinCode());

        details.setProblem(request.getProblem());
        details.setCustomers(request.getCustomers());
        details.setUniqueValue(request.getUniqueValue());
        details.setRevenue(request.getRevenue());
        details.setTeamSize(request.getTeamSize());
        details.setFundingStage(request.getFundingStage());

        startupDetailsRepository.save(details);
    }
    
    @Override
    public Optional<StartupDetails> getStartupDetails(Founder founder) {
        return startupDetailsRepository.findByFounder(founder);
    }
}