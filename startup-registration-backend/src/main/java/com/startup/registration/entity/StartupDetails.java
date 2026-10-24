
package com.startup.registration.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "startup_details")
public class StartupDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "founder_id", nullable = false, unique = true)
    private Founder founder;

    private String startupName;
    private String tagline;
    private String website;
    private String startupEmail;
    private String startupMobile;
    private String industry;
    private String startupStage;
    private String companyType;
    private String incorporationStatus;
    private LocalDate incorporationDate;
    private String cin;
    private String gstNumber;
    private String startupIndia;
    private String dpiitNumber;
    private String country;
    private String state;
    private String city;

    @Column(columnDefinition = "TEXT")
    private String address;

    private String pinCode;

    @Column(columnDefinition = "TEXT")
    private String problem;

    @Column(columnDefinition = "TEXT")
    private String customers;

    @Column(name = "unique_value", columnDefinition = "TEXT")
    private String uniqueValue;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Founder getFounder() {
		return founder;
	}

	public void setFounder(Founder founder) {
		this.founder = founder;
	}

	public String getStartupName() {
		return startupName;
	}

	public void setStartupName(String startupName) {
		this.startupName = startupName;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getStartupEmail() {
		return startupEmail;
	}

	public void setStartupEmail(String startupEmail) {
		this.startupEmail = startupEmail;
	}

	public String getStartupMobile() {
		return startupMobile;
	}

	public void setStartupMobile(String startupMobile) {
		this.startupMobile = startupMobile;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getStartupStage() {
		return startupStage;
	}

	public void setStartupStage(String startupStage) {
		this.startupStage = startupStage;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getIncorporationStatus() {
		return incorporationStatus;
	}

	public void setIncorporationStatus(String incorporationStatus) {
		this.incorporationStatus = incorporationStatus;
	}

	public LocalDate getIncorporationDate() {
		return incorporationDate;
	}

	public void setIncorporationDate(LocalDate incorporationDate) {
		this.incorporationDate = incorporationDate;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getStartupIndia() {
		return startupIndia;
	}

	public void setStartupIndia(String startupIndia) {
		this.startupIndia = startupIndia;
	}

	public String getDpiitNumber() {
		return dpiitNumber;
	}

	public void setDpiitNumber(String dpiitNumber) {
		this.dpiitNumber = dpiitNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getCustomers() {
		return customers;
	}

	public void setCustomers(String customers) {
		this.customers = customers;
	}

	public String getUniqueValue() {
		return uniqueValue;
	}

	public void setUniqueValue(String uniqueValue) {
		this.uniqueValue = uniqueValue;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}

	public String getFundingStage() {
		return fundingStage;
	}

	public void setFundingStage(String fundingStage) {
		this.fundingStage = fundingStage;
	}

	private String revenue;
    private String teamSize;
    private String fundingStage;

    public StartupDetails() {
    }

    // Generate getters and setters in Eclipse:
    // Right-click inside this class → Source → Generate Getters and Setters
}
