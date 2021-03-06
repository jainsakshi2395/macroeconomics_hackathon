package com.example.hackathon277;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.hackathon277.database.DatabaseAccess;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    GraphView graphView;
    Button getStartedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerCountry = findViewById(R.id.country);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerCountry.setAdapter(adapter);

        getStartedBtn = (Button) findViewById(R.id.GetStartedBtn);
        //OnclickListener implementation to change the activity
        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
            }
        });

      /* // this.listView = (ListView) findViewById(R.id.listView);
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
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
       // this.listView.setAdapter(adapter);
    }
}