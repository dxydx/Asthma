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

public class DiaryRecordAdapter extends ArrayAdapter<DiaryRecord> {

    public DiaryRecordAdapter (Activity context, ArrayList<DiaryRecord> diaryRecordArrayList){
        super (context, 0, diaryRecordArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int itemPosition = DiaryMainActivity.diaryRecord.size() - position - 1;

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.diary_record_item, parent, false);
        }

        // Get the object located at this position in the list
        DiaryRecord currentRecord = getItem(itemPosition);

        // Find the TextView in the list_item.xml layout
        TextView dtv = listItemView.findViewById(R.id.dateTextView);

        // Get the Date from the current record
        // set this text on the date Text View
        dtv.setText(currentRecord.getRecordDate());

        // Find the TextView in the list_item.xml layout
        TextView ptv = listItemView.findViewById(R.id.pfTextView);

        // Get the Default translation from the current Word object and
        // set this text on pf text view
        ptv.setText("" + currentRecord.getRecordPeakFlow());

        // Find the TextView in the list_item.xml layout
        TextView stv = listItemView.findViewById(R.id.symptomsTextView);

        // Get the Default translation from the current Word object and
        // set the text on symptoms text view
        stv.setText(currentRecord.getRecordSymptoms());

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
