package com.medical.MediConnect.MediConnect.Repository;

import com.medical.MediConnect.MediConnect.Model.PatientsMedicalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientsMedicalDetailsRepo extends JpaRepository<PatientsMedicalDetails, Integer> {


    Optional<PatientsMedicalDetails> findByPatientId(int patientId);

    List<PatientsMedicalDetails> findAllByPatientId(int patientId);
}
