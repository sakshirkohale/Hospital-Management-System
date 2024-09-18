package com.HMSApp.Hospital.Management.Sysem.docLoginRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSApp.Hospital.Management.Sysem.docLogin.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
