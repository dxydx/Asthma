package com.example.android.asthma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class AppointmentsMainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static ArrayList<AppointmentsRecord> appointmentsRecord = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointments_main);

        // use placeholders to create previous appointment records - for demonstration only
        if (appointmentsRecord.isEmpty()) {
            Calendar testDate = Calendar.getInstance();
            testDate.clear();
            testDate.set(2019,4,8,10,0);
            appointmentsRecord.add(new AppointmentsRecord(testDate.getTime().toString(), "Dr XYZ", getString(R.string.attended)));
            testDate.clear();
            testDate.set(2019,4,3,14,15);
            appointmentsRecord.add(new AppointmentsRecord(testDate.getTime().toString(), "Dr XYZ", getString(R.string.missed)));
        }

        // build arraylist from memory store

        // show next appointment
        showNextAppointment();

        // arrayadapter and listview for arraylist
        AppointmentsRecordAdapter appointmentsRecordAdapter = new AppointmentsRecordAdapter(this, appointmentsRecord);

        ListView listView = findViewById(R.id.appt_record_list);

        listView.setAdapter(appointmentsRecordAdapter);
    }

    public void showNextAppointment() {
        // use placeholders for next appointment record
        Calendar newDate = Calendar.getInstance();
        newDate.clear();
        newDate.set(2019, 9, 1, 15, 0);

        String nDr = "Dr XYZ";

        // get day of week from calendar


        // check if there is any next appointment
        // check if the date of the next appointment has passed. if so, save record as 'missed' and return;
        /**
         if (next appt date has passed - give maybe 1 day grace){
         save record - perhaps use method from the spinner below?
         // create alert that no new appt has been set [for alerts menu on main page]
         return;
         }
         */

        // show next appointment
        TextView nextDate = findViewById(R.id.nextDateTextView);
        nextDate.setText(newDate.getTime().toString());

        TextView nextDr = findViewById(R.id.nextDoctorTextView);
        nextDr.setText(nDr);

        Spinner spinner = findViewById(R.id.nextStatusSpinner);
        spinner.setEnabled(true);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.appt_status_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void enterNewAppointment(View view) {
        // check if there is a next appointment
        // if so - toast that there shld be only one future appt
        // if not - open dialog box to fill in required variables
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // if attended/cancelled status has not been chosen, do not save record
        if (parent.getItemAtPosition(position).toString().equalsIgnoreCase(getString(R.string.status))){
            return;
        }

        // open confirmation box

        // save data in repository

        // use array as placeholder for now
        TextView nextDate = findViewById(R.id.nextDateTextView);
        TextView nextDr = findViewById(R.id.nextDoctorTextView);
        appointmentsRecord.add(new AppointmentsRecord(nextDate.getText().toString(),nextDr.getText().toString(), parent.getItemAtPosition(position).toString()));

        // remove next appointment


        // refresh activity to display new list of appointments
        finish();
        startActivity(getIntent());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    /**
     methods to get day of week and month from calendar date
     not currently being used

    public String getDayOfWeek (Calendar calendar){
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                return "Mon";
            case Calendar.TUESDAY:
                return "Tue";
            case Calendar.WEDNESDAY:
                return "Wed";
            case Calendar.THURSDAY:
                return "Thu";
            case Calendar.FRIDAY:
                return "Fri";
            case Calendar.SATURDAY:
                return "Sat";
            case Calendar.SUNDAY:
                return "Sun";
        }
        return getString(R.string.date_error);
    }

    public String getMonthOfYear (Calendar calendar){
        switch (calendar.get(Calendar.MONTH)) {
            case Calendar.JANUARY:
                return "Jan";
            case Calendar.FEBRUARY:
                return "Feb";
            case Calendar.MARCH:
                return "Mar";
            case Calendar.APRIL:
                return "Apr";
            case Calendar.MAY:
                return "May";
            case Calendar.JUNE:
                return "Jun";
            case Calendar.JULY:
                return "Jul";
            case Calendar.AUGUST:
                return "Aug";
            case Calendar.SEPTEMBER:
                return "Sep";
            case Calendar.OCTOBER:
                return "Oct";
            case Calendar.NOVEMBER:
                return "Nov";
            case Calendar.DECEMBER:
                return "Dec";
        }
        return getString(R.string.date_error);
    }
     */
}