package com.medical.MediConnect.MediConnect.Controllers;

import com.medical.MediConnect.MediConnect.Model.LoginFormEntity;
import com.medical.MediConnect.MediConnect.Services.LoginAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PatientsController {

    @Autowired
    LoginAuthenticationService loginAuthenticationService;

    @CrossOrigin
    @RequestMapping(value = "/patientLogin", method = RequestMethod.POST)
    public int patientLogin(@RequestBody LoginFormEntity loginEntity){

        return loginAuthenticationService.validatePatientLogin(loginEntity.getUsername(), loginEntity.getPassword()).getId();
    }

}
