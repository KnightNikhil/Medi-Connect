package com.medical.MediConnect.MediConnect.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PatientsMedicalDetails {

    @Id
    int id;
    int patientId;
    int doctorId;
    double patientWeight;
    int patientAge;
    String symptoms;
    String medicinePrescribed;
    String clinicalDiagnosis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public PatientsMedicalDetails(){};

    public PatientsMedicalDetails(int id, int doctorId, int patientId, double patientWeight, int patientAge, String symptoms, String medicinePrescribed, String clinicalDiagnosis) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.patientWeight = patientWeight;
        this.patientAge = patientAge;
        this.symptoms = symptoms;
        this.medicinePrescribed = medicinePrescribed;
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public double getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(float patientWeight) {
        this.patientWeight = patientWeight;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getMedicinePrescribed() {
        return medicinePrescribed;
    }

    public void setMedicinePrescribed(String medicinePrescribed) {
        this.medicinePrescribed = medicinePrescribed;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }
}
