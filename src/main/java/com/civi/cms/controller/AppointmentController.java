package com.civi.cms.controller;

import com.civi.cms.model.Appointment;

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


    @PostMapping("/create") //this API has been tested and works
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointmentObj) {
        Appointment createAppointment = appointmentService.createAppointment(appointmentObj);
        return ResponseEntity.ok(createAppointment);
    }

    @GetMapping("/get") //tested in postman
    public ResponseEntity<List<Appointment>> getAllAppointment()
    {
        List<Appointment> appointment = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointment);
    }

    @GetMapping("/get/id/{id}") //tested in postman
    public ResponseEntity<Appointment> getAllAppointmentById(Long id)
    {
        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/get/client-email/{email}") //tested in postman
    public ResponseEntity<List<Appointment>> getAllAppointmentById(String email)
    {
        return appointmentService.getAppointmentByClientEmail(email);
    }



    //to update appointments based on id

//    @PutMapping("/update")
//    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointmentObj)
//    {
//        {
//            Appointment updatedAppointmentDetails = appointmentService.updateAppointment(appointmentObj);
//            //CaseDetails updatedCaseDetails = caseDetailService.updateCase(caseDetailsObj);
//            return ResponseEntity.ok(updatedAppointmentDetails);
//        }
//    }

//    @DeleteMapping("/{id}") //tested in postman already, its working
//    public ResponseEntity<Boolean> deleteAppointment(@PathVariable Long id)
//    {
//
//        return ResponseEntity.ok(appointmentService.deleteAppointment(id));
//    }



}