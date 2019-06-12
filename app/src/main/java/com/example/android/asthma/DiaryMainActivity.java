package com.example.android.asthma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

public class DiaryMainActivity extends AppCompatActivity {

    // placeholder
    public static ArrayList<DiaryRecord> diaryRecord = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_main_page);

        // set the current date and time to now
        TextView view1 = findViewById(R.id.date);
        view1.setText(Calendar.getInstance().getTime().toString());

        // use placeholders for diary records for now - these are for demonstration only
        if (diaryRecord.isEmpty()){
            diaryRecord.add(new DiaryRecord("Sat May 04 08:13:03 GMT +08:00 2019", 600, "Well (No symptoms)"));
            diaryRecord.add(new DiaryRecord("Sat May 04 22:51:49 GMT +08:00 2019", 580, "Well (No symptoms)"));
        }
    }

    // executed when the date box is clicked
    public void openDatePickerDialog(View view) {
        // open calendar to allow user to select date
        // set the date
    }

    public void checkBoxChecker(View view) {
        //ignore error message - this method is used but the coding is in styles rather than in the xml
        resetCheckBoxes((CheckBox) findViewById(R.id.checkBox1), (CheckBox) findViewById(R.id.checkBox2), (CheckBox) findViewById(R.id.checkBox3));
        CheckBox checkbox = (CheckBox) view;
        checkbox.setChecked(true);
    }

    // set the date and time to current date and time when the 'now' button is clicked
    public void setNow(View view) {
        // sets the current date and time to now
        TextView view1 = findViewById(R.id.date);
        view1.setText(Calendar.getInstance().getTime().toString());
    }

    // stores variables and saves as a record
    public void saveRecord(View view) {
        // get state of variables, then checks that required fields are filled in
        TextView dateTextView = findViewById(R.id.date);

        EditText pefrEditText = findViewById(R.id.pefr_value);

        // ensures only numbers are entered for PEFR value
        try {
            Integer.parseInt(pefrEditText.getText().toString());
        } catch (Exception NumberFormatException) {
            pefrEditText.setText("");
            Toast.makeText(getApplicationContext(), getString(R.string.toast_error2), Toast.LENGTH_SHORT).show();
            return;
        }

        int pefr_value = Integer.parseInt(pefrEditText.getText().toString());

        // check that required fields are filled in, and PEFR is between 1-1000
        if (dateTextView.getText() != null && pefr_value > 0 && pefr_value < 1001 && checkCheckBoxState((CheckBox) findViewById(R.id.checkBox1), (CheckBox) findViewById(R.id.checkBox2), (CheckBox) findViewById(R.id.checkBox3))) {

            // store data in repository

            // save data into array for now to demonstrate
            diaryRecord.add(new DiaryRecord(dateTextView.getText().toString(), pefr_value, checkSymptoms((CheckBox) findViewById(R.id.checkBox1), (CheckBox) findViewById(R.id.checkBox2), (CheckBox) findViewById(R.id.checkBox3))));

            // show toast that record has been saved
            Toast.makeText(getApplicationContext(), getString(R.string.toast_record_saved), Toast.LENGTH_SHORT).show();

            // reset variables
            resetVariables((TextView) findViewById(R.id.date), (EditText) findViewById(R.id.pefr_value));
        }

        // if required fields are not filled in, show error message
        else {
            Toast.makeText(getApplicationContext(), getString(R.string.toast_error), Toast.LENGTH_SHORT).show();
        }
    }

    // executed when view summary is clicked
    // takes the user to a new page that shows the summary view
    public void viewSummary(View view) {
        Intent diarySummaryIntent = new Intent(DiaryMainActivity.this, DiarySummaryActivity.class);
        startActivity(diarySummaryIntent);
    }

    public void resetVariables(TextView dateTextView, EditText pefrEditText) {
        // reset date, pefr values
        dateTextView.setText("");

        pefrEditText.setText("");

        // resets checkboxes
        resetCheckBoxes((CheckBox) findViewById(R.id.checkBox1), (CheckBox) findViewById(R.id.checkBox2), (CheckBox) findViewById(R.id.checkBox3));
    }

    public void resetCheckBoxes(CheckBox cb1, CheckBox cb2, CheckBox cb3) {
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
    }

    public boolean checkCheckBoxState (CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3) {
        return (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked());
    }

    public String checkSymptoms (CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3) {

        // check checkboxes and convert to string for storing symptoms
        if (checkBox1.isChecked()){
            return(getString(R.string.symptom1));
        } else if (checkBox2.isChecked()){
            return(getString(R.string.symptom2));
        } else if (checkBox3.isChecked()){
            return(getString(R.string.symptom3));
        } else {
            return(getString(R.string.symptom_error));
        }
    }

    public void showToolTip (View view){
        Toast.makeText(this, getString(R.string.PEFR_tooltip), Toast.LENGTH_SHORT).show();
    }

}
