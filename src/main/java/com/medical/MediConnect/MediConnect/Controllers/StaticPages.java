package com.medical.MediConnect.MediConnect.Controllers;

import com.medical.MediConnect.MediConnect.Model.Doctors;
import com.medical.MediConnect.MediConnect.Repository.FetchDoctors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class StaticPages {

    @Autowired
    FetchDoctors fetchDoctors;

    @RequestMapping("")
    public String Homepage(){
        return "Hello Home";
    }

    @RequestMapping("allDoctors")
    public List<Doctors> getAllDoctors(){

        List<Doctors> doctors = new ArrayList<>();
        doctors = fetchDoctors.findAll();

        return doctors;
    }

    @RequestMapping(value="findDoctorsBySpecializaion", method= RequestMethod.POST)
    public List<Doctors> findDoctors( @RequestBody String searchSpecialization){

        List<Doctors> doctors = new ArrayList<>();

        doctors = fetchDoctors.findBySpecialization(searchSpecialization);

        return doctors;
    }


    @RequestMapping("getAllSpecializations.json")
    public List<String> getAllSpecializations(){

        List<String> specilaizations = new ArrayList<>();
        specilaizations = fetchDoctors.getAllSpecializations();

        return specilaizations;
    }

}
