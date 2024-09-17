package com.medical.MediConnect.MediConnect.Model;


import jakarta.persistence.*;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.Arrays;
import java.util.Date;

@Entity
public class DiagnosisReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int patientId;
    int doctorId;
    int medicalHistoryId;
    Date date;
    byte[] document;
    String documentName;

    @Column(name = "document_url_s3")
    String documentUrlS3;

    public String getDocumentUrlS3() {
        return documentUrlS3;
    }

    public void setDocumentUrlS3(String documentUrlS3) {
        this.documentUrlS3 = documentUrlS3;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

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

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public int getMedicalHistoryId() {
        return medicalHistoryId;
    }

    public void setMedicalHistoryId(int medicalHistoryId) {
        this.medicalHistoryId = medicalHistoryId;
    }

    public DiagnosisReports(int id, int patientId, int doctorId, int medicalHistoryId, Date date, byte[] document, String documentName, String documentUrlS3) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.medicalHistoryId = medicalHistoryId;
        this.date = date;
        this.document = document;
        this.documentName = documentName;
        this.documentUrlS3 = documentUrlS3;
    }

    public DiagnosisReports() {
    }

    @Override
    public String toString() {
        return "DiagnosisReportsBean{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", medicalHistoryId=" + medicalHistoryId +
                ", date=" + date +
                ", document=" + Arrays.toString(document) +
                ", documentName='" + documentName + '\'' +
                '}';
    }
}
