package com.example.android.asthma;

public class DiaryRecord {

    private String recordDate;
    private int recordPeakFlow;
    private String recordSymptoms;

    public DiaryRecord(String date, int peakFlow, String symptoms) {
        recordDate = date;
        recordPeakFlow = peakFlow;
        recordSymptoms = symptoms;
    }
    // methods to obtain data

    public String getRecordDate() {
        return recordDate;
    }

    public int getRecordPeakFlow() {
        return recordPeakFlow;
    }

    public String getRecordSymptoms() {
        return recordSymptoms;
    }

    /**
     // methods to modify data

     public void setRecordDate (String date) {
     recordDate = date;
     }

     public void setRecordPeakFlow (int peakFlow){
     recordPeakFlow = peakFlow;
     }

     public void setRecordSymptoms (String symptoms){
     recordSymptoms = symptoms;
     }
     */
}
