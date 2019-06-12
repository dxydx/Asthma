package com.example.android.asthma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class DiarySummaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_record_list);

        // build arraylist from memory store

        // arrayadapter and listview for arraylist
        DiaryRecordAdapter diaryAdapter = new DiaryRecordAdapter(this, DiaryMainActivity.diaryRecord);

        ListView listView = findViewById(R.id.record_list);

        listView.setAdapter(diaryAdapter);
    }

    public void showDiaryGraph(View view){
        Intent graphIntent = new Intent(DiarySummaryActivity.this, DiaryGraphActivity.class);
        startActivity(graphIntent);
    }
}
