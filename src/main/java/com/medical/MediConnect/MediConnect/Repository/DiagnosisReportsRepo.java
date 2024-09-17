package com.medical.MediConnect.MediConnect.Repository;

import com.medical.MediConnect.MediConnect.Model.DiagnosisReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisReportsRepo extends JpaRepository<DiagnosisReports, Integer> {
    List<DiagnosisReports> findByMedicalHistoryId(int i);
}
