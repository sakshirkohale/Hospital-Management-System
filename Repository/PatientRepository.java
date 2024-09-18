package com.HMSApp.Hospital.Management.Sysem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSApp.Hospital.Management.Sysem.Entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{

}
