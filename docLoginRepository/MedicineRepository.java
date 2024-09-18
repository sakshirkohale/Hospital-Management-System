package com.HMSApp.Hospital.Management.Sysem.docLoginRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSApp.Hospital.Management.Sysem.docLogin.entity.Medicine;

@Repository 
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

}
