package com.civi.cms.controller;

import com.civi.cms.model.Appointment;
import com.civi.cms.model.CaseDetails;
import com.civi.cms.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    //get all appointments
    //@GetMapping("/appointment")
    //public ResponseEntity<List<Appointment>> getAllAppointments() {
    //List<Appointment> appointmentDetails = AppointmentService.getAllAppointments();

    //return ResponseEntity.ok(appointmentDetails);

    //}

    @PostMapping("/create") //this API has been tested and works
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointmentObj) {
        Appointment createAppointment = appointmentService.createAppointment(appointmentObj);
        return ResponseEntity.ok(createAppointment);

    }

    @GetMapping("/get") //tested in postman
    public ResponseEntity<List<Appointment>> getAllAppointment() {
        List<Appointment> appointment = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointment);
    }


    //to update appointments based on id

    @PutMapping("/update")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointmentObj) {
        {
            Appointment updatedAppointmentDetails = appointmentService.updateAppointment(appointmentObj);
            //CaseDetails updatedCaseDetails = caseDetailService.updateCase(caseDetailsObj);
            return ResponseEntity.ok(updatedAppointmentDetails);
        }
    }
}