package com.civi.cms.service;

import com.civi.cms.model.Appointment;
import com.civi.cms.model.CaseDetails;
import com.civi.cms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppointmentService 
{
    @Autowired
    private AppointmentRepository appointmentRepository;


    public Appointment createAppointment(Appointment appointmentObj)
    {
         return appointmentRepository.save(appointmentObj);
    }

    public List<Appointment> getAllAppointments()
    {
        //returning an object
        return appointmentRepository.findAll();
    }

    //public List<CaseDetails> getAllCases() {
       // return caseDetailRepository.findAll();
    //}

}
