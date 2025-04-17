package com.civi.cms.service;

import com.civi.cms.model.Appointment;
import com.civi.cms.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Appointment> getAppointmentById(Long id) {
        Optional<Appointment> appointment= appointmentRepository.findById(id);
        if(appointment.isPresent())
            return ResponseEntity.ok().body(appointment.get());
        else
            return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Appointment>> getAppointmentByClientEmail(String email) {
        //get appointment by client email
            List<Appointment> appointments = appointmentRepository.findByClientEmail(email);
        if (!appointments.isEmpty()) {
            return ResponseEntity.ok().body(appointments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
