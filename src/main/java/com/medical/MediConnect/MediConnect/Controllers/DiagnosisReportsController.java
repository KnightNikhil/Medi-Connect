package com.medical.MediConnect.MediConnect.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medical.MediConnect.MediConnect.Model.DiagnosisReports;
import com.medical.MediConnect.MediConnect.Model.DiagnosisReportsInputBean;
import com.medical.MediConnect.MediConnect.Repository.DiagnosisReportsRepo;
import com.medical.MediConnect.MediConnect.Services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class DiagnosisReportsController {

    @Autowired
    DiagnosisReportsRepo diagnosisReportsRepo;

    @Autowired
    S3Service s3Service;

    @RequestMapping(value="uploadDiagnosisReports", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public String uploadDiagnosisReports(@RequestPart("document") MultipartFile document, @RequestPart("uploadDetails") String uploadDetails){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DiagnosisReports diagnosisReports = objectMapper.readValue(uploadDetails, DiagnosisReports.class);
            diagnosisReports.setDocument(document.getBytes());
            diagnosisReports.setDocumentName(document.getOriginalFilename());
            diagnosisReports.setDate(new Date());
            diagnosisReports.setDocumentUrlS3(s3Service.uploadFileToS3(document));

            diagnosisReportsRepo.save(diagnosisReports);
            return "SUCCESS";

        } catch (Exception e){
            System.out.println(e);
        }
        return "FAIL";
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="getDiagnosisReports", method = RequestMethod.POST)
    public List<DiagnosisReports> getDiagnosisReports(@RequestBody DiagnosisReportsInputBean diagnosisReportsInputBean){
        List<DiagnosisReports> diagnosisReports =  diagnosisReportsRepo.findByMedicalHistoryId(diagnosisReportsInputBean.getMedicalHistoryId());
        try {
            for (DiagnosisReports diagnosisReport : diagnosisReports){
                diagnosisReport.setDocument(s3Service.downloadFileFromS3(diagnosisReport.getDocumentName()));
            }
        } catch (IOException e){
        System.out.println(e);
        }
        return diagnosisReports;
    }



}
