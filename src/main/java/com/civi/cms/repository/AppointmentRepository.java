package com.civi.cms.repository;
import com.civi.cms.model.Appointment;
import com.civi.cms.model.CaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>
{
    //all methods are created by JpaRep
    //line number12 -- that indicates the param used
}


