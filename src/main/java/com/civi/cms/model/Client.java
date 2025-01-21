package com.civi.cms.model;

import jakarta.persistence.*;

@Entity
public class Client
{

   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long clientId;            // Primary Key
    private String firstName;
    private String lastName;
    private String gender;
    @Id
    private String clientEmail;
    private String clientPhoneNumber;

   // public Long getClientId() {
    //    return clientId;
    //}

    //public void setClientId(Long clientId) {
       // this.clientId = clientId;
   // }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }
}
