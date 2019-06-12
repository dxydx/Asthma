package com.example.android.asthma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check for updates
        checkUpdates();

        // create language spinner
        createSpinner();

        /**
         //check for alerts
         if(alerts > 0){
         // show the alerts
         set alert visibility to true
         set text to number of alerts
         }
         */

    }

    public void checkUpdates() {
        // check for updates
    }

    public void createSpinner() {
        Spinner spinner = findViewById(R.id.language_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void showDiary(View view){
        Intent diaryIntent = new Intent(MainActivity.this, DiaryMainActivity.class);
        startActivity(diaryIntent);
    }

    public void showActionPlan (View view){
        Intent apIntent = new Intent(MainActivity.this, ActionPlanMainActivity.class);
        startActivity(apIntent);
    }

    public void showAppointments(View view){
        Intent aIntent = new Intent(MainActivity.this, AppointmentsMainActivity.class);
        startActivity(aIntent);
    }

    public void showMenu (View view) {
        Intent mIntent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(mIntent);
    }

    public void showAlerts (View view){
        Intent aIntent = new Intent(MainActivity.this, AlertsActivity.class);
        startActivity(aIntent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).toString().equalsIgnoreCase("English")){
            // set language to english
        } else if (parent.getItemAtPosition(position).toString().equalsIgnoreCase("中文")){
            // set language to chinese
        } else if (parent.getItemAtPosition(position).toString().equalsIgnoreCase("Bahasa Melayu")){
            // set language to malay
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
