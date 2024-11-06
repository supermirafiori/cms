package com.civi.cms.model;

import java.time.LocalDateTime;

public class Appointment
{
   private Long appointmentId;
   private LocalDateTime appointmentDateTime;
   private String status;
   private String location;
   private String notes;
   private Long caseId;
}
