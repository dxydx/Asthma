package com.example.android.asthma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DiaryGraphActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary_graph_page);
        drawDailyGraph(findViewById(R.id.dailyTab));
    }

    public void drawDailyGraph (View view) {
        // draw the daily graph
    }

    public void drawDiurnalGraph (View view){
        // draw the diurnal graph
    }

    public void showDiaryTable(View view) {
        Intent i = new Intent(DiaryGraphActivity.this, DiarySummaryActivity.class);
        startActivity(i);
    }

}
