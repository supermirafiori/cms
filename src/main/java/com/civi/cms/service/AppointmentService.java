package com.civi.cms.service;

import com.civi.cms.model.Appointment;
import com.civi.cms.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Appointment updateAppointment(Appointment appointmentObj)
    {
        if (appointmentRepository.existsById(appointmentObj.getAppointmentId()))
        {
            return
            appointmentRepository.save(appointmentObj);
        }

        // Save and return the updated appointment object
        return null;
    }


    public Boolean deleteAppointment(Long id)
    {
        if (appointmentRepository.existsById(id)) {
            //throw new RuntimeException("Case not found with ID: " + id);
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
