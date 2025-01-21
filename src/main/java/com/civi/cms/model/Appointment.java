package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Appointment
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long appointmentId;
   private LocalDateTime appointmentDateTime;
   private String status;
   private String location;
   private String notes;
   private String bookedBy;

   private String clientMobileNumber;



    public String getClientMobileNumber() {
      return clientMobileNumber;
   }

   public void setClientMobileNumber(String clientMobileNumber) {
      this.clientMobileNumber = clientMobileNumber;
   }

   public Long getAppointmentId() {
      return appointmentId;
   }

   public void setAppointmentId(Long appointmentId) {
      this.appointmentId = appointmentId;
   }

   public LocalDateTime getAppointmentDateTime() {
      return appointmentDateTime;
   }

   public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
      this.appointmentDateTime = appointmentDateTime;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public String getNotes() {
      return notes;
   }

   public void setNotes(String notes) {
      this.notes = notes;
   }

   public String getBookedBy() {
      return bookedBy;
   }

   public void setBookedBy(String bookedBy) {
      this.bookedBy = bookedBy;
   }
}
