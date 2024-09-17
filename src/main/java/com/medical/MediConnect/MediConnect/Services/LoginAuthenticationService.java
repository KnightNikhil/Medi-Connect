package com.medical.MediConnect.MediConnect.Services;

import com.medical.MediConnect.MediConnect.Model.LoginEntity;
import com.medical.MediConnect.MediConnect.Model.LoginFormEntity;
import com.medical.MediConnect.MediConnect.Model.PatientDetails;
import com.medical.MediConnect.MediConnect.Repository.FetchDoctorsDetails;
import com.medical.MediConnect.MediConnect.Repository.PatientDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class LoginAuthenticationService {
    @Autowired
    FetchDoctorsDetails fetchDoctorsDetails;

    @Autowired
    PatientDetailsRepo patientDetailsRepo;

    public int validateDoctorLogin(LoginFormEntity loginFormEntity) {
        LoginEntity loginEntity = fetchDoctorsDetails.findByUsername(loginFormEntity.getUsername()).getFirst();
        if (loginFormEntity.getPassword().equals(loginEntity.getPassword()))
            return loginEntity.getId();
        else
            return -1;
    }

    public PatientDetails validatePatientLogin(String username, String password){
        PatientDetails patientDetails = patientDetailsRepo.findByUsername(username).getFirst();
        if(patientDetails!=null && patientDetails.getPassword()!=null &&
            patientDetails.getPassword().equals(password)){
            Calendar birthCalendar = Calendar.getInstance();
            birthCalendar.setTime(patientDetails.getDateOfBirth());
            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR) > 0 ? today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR) : -1;
            if (today.get(Calendar.DAY_OF_YEAR) > birthCalendar.get(Calendar.DAY_OF_YEAR))
                age--;
            return patientDetails;
        }
        return null;
    }
}
