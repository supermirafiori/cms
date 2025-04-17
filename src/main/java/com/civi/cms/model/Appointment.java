package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Appointment
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long appointmentId;
   private LocalDateTime appointmentDateTime;
   private AppointmentStatus status;
   private String location;
   private String notes;
   private String bookedBy;
   private String clientMobileNumber;
   private String clientEmail;

   public enum AppointmentStatus{
      BOOKED,
      CONFIRMED,
      CANCELLED
   }
}
