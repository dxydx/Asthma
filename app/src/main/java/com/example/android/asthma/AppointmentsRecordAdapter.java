package com.example.android.asthma;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class AppointmentsRecordAdapter extends ArrayAdapter<AppointmentsRecord> {

    public AppointmentsRecordAdapter (Activity context, ArrayList<AppointmentsRecord> appointmentsRecordArrayList){
        super (context, 0, appointmentsRecordArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int itemPosition = AppointmentsMainActivity.appointmentsRecord.size() - position - 1;

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.appt_record_item, parent, false);
        }

        // Get the object located at this position in the list
        AppointmentsRecord currentRecord = getItem(itemPosition);

        // Find the TextView in the list_item.xml layout
        TextView dtv = listItemView.findViewById(R.id.dateTextView);

        // Get the Date from the current record
        // set this text on the date Text View
        dtv.setText(currentRecord.getRecordDate());

        // Find the TextView in the list_item.xml layout
        TextView drtv = listItemView.findViewById(R.id.doctorTextView);

        // Get the Default translation from the current Word object and
        // set this text on pf text view
        drtv.setText(currentRecord.getRecordDoctor());

        // Find the TextView in the list_item.xml layout
        TextView stv = listItemView.findViewById(R.id.statusTextView);

        // Get the Default translation from the current Word object and
        // set the text on symptoms text view
        stv.setText(currentRecord.getRecordStatus());

        if (stv.getText().toString().equalsIgnoreCase("attended")){
            // changes text color to green if appointment was attended
            stv.setTextColor(0xAA388E3C);
        } else if (stv.getText().toString().equalsIgnoreCase("missed")){
            // changes text color to red if appointment was missed
            stv.setTextColor(0xAAD32F2F);
        } else {
            // otherwise keeps text color black
            stv.setTextColor(0xAA212121);
        }

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
