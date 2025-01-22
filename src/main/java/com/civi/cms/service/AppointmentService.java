package com.civi.cms.service;

import com.civi.cms.model.Appointment;
import com.civi.cms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    public Appointment updateAppointment(Long id , Appointment appointmentObj)
    {
        if(appointmentRepository.existsById(id))
        {
            throw new RuntimeException(("Appointment not found with ID :" + id));
        }
        appointmentObj.setAppointmentId(id);
        return appointmentRepository.save(appointmentObj);
    }

    //public List<CaseDetails> getAllCases() {
       // return caseDetailRepository.findAll();
    //}

    //public CaseDetails updateCase(Long id, CaseDetails caseDetailsObj) {
      //  if (caseDetailRepository.existsById(id)) {
        //    throw new RuntimeException("Case not found with ID: " + id);
        //}
        //caseDetailsObj.setCaseId(id);
        //return caseDetailRepository.save(caseDetailsObj);
    //}

}
