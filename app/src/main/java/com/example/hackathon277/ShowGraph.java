package com.example.hackathon277;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon277.database.DatabaseAccess;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;

public class ShowGraph extends AppCompatActivity {

    GraphView graphView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showgraph);

      /*
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> quotes = databaseAccess.getGDPGrowthYear();
        List<String> usList = databaseAccess.getGDPUS();

        graphView = findViewById(R.id.idGraphView);


        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        for (int i=0;i<quotes.size();i++) {
            if(null==quotes.get(i) || null == usList.get(i)){
                continue;
            }else{
                series.appendData(new DataPoint(Integer.parseInt(quotes.get(i)),Double.parseDouble(usList.get(i))),true,90);
            }

        }


        graphView.setTitle("My Graph View");
        graphView.setTitleColor(R.color.purple_200);
        graphView.setTitleTextSize(18);

        GridLabelRenderer gridLabel = graphView.getGridLabelRenderer();
        gridLabel.setHorizontalAxisTitle("year");
        gridLabel.setVerticalAxisTitle("GDP Growth for US");

        graphView.addSeries(series);

        databaseAccess.close();

       */


    }
}
