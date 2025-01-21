package com.civi.cms.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CaseWorker {
    private String firstName;
    private String lastName;
    @Id
    private String email;
    @Column(nullable = false, unique = true)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "case_worker_id_seq")
    @SequenceGenerator(name = "auto_increment_seq", sequenceName = "auto_increment_seq", allocationSize = 1)

    private long caseWorkerId;  //similar to userId
    private String phoneNumber;
    private String jobTitle;
    private String departmentId;
    private String idNumber;
    private long organisationId;
    private String location;
    private String officeAddress;
    private String qualification;

    @OneToMany(mappedBy = "assignedCaseWorker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CaseDetails> caseDetails;

    public List<CaseDetails> getCases() {
        return caseDetails;
    }

    public void setCases(List<CaseDetails> caseDetails) {
        this.caseDetails = caseDetails;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCaseWorkerId() {
        return caseWorkerId;
    }

    public void setCaseWorkerId(long caseWorkerId) {
        this.caseWorkerId = caseWorkerId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }
}


