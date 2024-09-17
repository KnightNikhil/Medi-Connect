package com.medical.MediConnect.MediConnect.Repository;

import com.medical.MediConnect.MediConnect.Model.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FetchDoctors extends JpaRepository<Doctors, Integer> {

    List<Doctors> findBySpecialization(String specialization);

    @Query("select specialization from Doctors")
    List<String> getAllSpecializations();
}
