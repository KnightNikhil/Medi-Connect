package com.medical.MediConnect.MediConnect.Controllers;

import com.medical.MediConnect.MediConnect.Model.PatientDetails;
import com.medical.MediConnect.MediConnect.Model.PatientsMedicalDetails;
import com.medical.MediConnect.MediConnect.Repository.PatientDetailsRepo;
import com.medical.MediConnect.MediConnect.Repository.PatientsMedicalDetailsRepo;
//import com.medical.MediConnect.MediConnect.Services.LoginAuthenticationService;
import com.medical.MediConnect.MediConnect.Model.LoginFormEntity;
import com.medical.MediConnect.MediConnect.Services.LoginAuthenticationService;
//import com.medical.MediConnect.MediConnect.Services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class DoctorsController {

    @Autowired
    LoginAuthenticationService loginAuthenticationService;

    @Autowired
    PatientDetailsRepo patientDetailsRepo;


    @Autowired
    PatientsMedicalDetailsRepo patientsMedicalDetailsRepo;

    @RequestMapping(value="/doctorLogin", method = RequestMethod.POST)
    public int doctorLogin(@RequestBody LoginFormEntity loginFormEntity){

        return loginAuthenticationService.validateDoctorLogin(loginFormEntity);
    }

    @RequestMapping(value="/patientDetails", method = RequestMethod.POST)
    public Optional<PatientDetails> patientDetails(@RequestBody int id){

        return patientDetailsRepo.findById(id);
    }

    @RequestMapping(value="/patientHistory", method = RequestMethod.POST)
    public List<PatientsMedicalDetails> patientHistory(@RequestBody int patientId){

        return patientsMedicalDetailsRepo.findAllByPatientId(patientId);
    }

    @RequestMapping(value="/prescribePatient", method = RequestMethod.POST)
    public PatientsMedicalDetails prescribePatient(@RequestBody PatientsMedicalDetails patientsMedicalDetails){

        return patientsMedicalDetailsRepo.save(patientsMedicalDetails);
    }

}
