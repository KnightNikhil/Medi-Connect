package com.medical.MediConnect.MediConnect.Repository;

import com.medical.MediConnect.MediConnect.Model.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientDetailsRepo extends JpaRepository<PatientDetails, Integer> {

    List<PatientDetails> findByUsername(String username);
}
