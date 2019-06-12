package com.example.android.asthma;

public class AppointmentsRecord {

    private String recordDate;
    private String recordDoctor;
    private String recordStatus;

    public AppointmentsRecord(String date, String doctor, String status) {
        recordDate = date;
        recordDoctor = doctor;
        recordStatus = status;
    }
    // methods to obtain data

    public String getRecordDate() {
        return recordDate;
    }

    public String getRecordDoctor() {
        return recordDoctor;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    // method to amend the status of a record
    public void setRecordStatus (String status) {
        recordStatus = status;
    }
}