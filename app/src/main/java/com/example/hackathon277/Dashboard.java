package com.example.hackathon277;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hackathon277.database.DatabaseAccess;
import com.google.android.material.tabs.TabLayout;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.List;

public class Dashboard extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    GraphView graphView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new Fragment_Macro(), "Macroeconomic");
        vpAdapter.addFragment(new Fragment_Agri(), "Agriculture");
        vpAdapter.addFragment(new Fragment_Trade(), "Trade");
        viewPager.setAdapter(vpAdapter);
    }

    public void show_graph(View view) {

        Intent intent = new Intent(getApplicationContext(), ShowGraph.class);
        startActivity(intent);

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        setContentView(R.layout.showgraph);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_1:
                if (checked)
                    // this.listView = (ListView) findViewById(R.id.listView);


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



                graphView.setTitle("Macroeconomics Data");
                graphView.setTitleColor(R.color.purple_200);
                graphView.setTitleTextSize(18);

                GridLabelRenderer gridLabel = graphView.getGridLabelRenderer();
                gridLabel.setHorizontalAxisTitle("Year");
                gridLabel.setVerticalAxisTitle("USD");

                graphView.addSeries(series);


                databaseAccess.close();

                break;
            case R.id.radio_2:
                if (checked)
                    databaseAccess.open();
                List<String> quotes2 = databaseAccess.getGDPGrowthYear();
                List<String> usList2 = databaseAccess.getGDPUS();
                List<String> usIndia = databaseAccess.getGDPIndia();
                List<String> usChina = databaseAccess.getGDPChina();

                graphView = findViewById(R.id.idGraphView);


                LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>();
                for (int i=0;i<quotes2.size();i++) {
                    if(null==quotes2.get(i) || null == usList2.get(i)){
                        continue;
                    }else{
                        series1.appendData(new DataPoint(Integer.parseInt(quotes2.get(i)),Double.parseDouble(usList2.get(i))),true,90);
                    }

                }

                LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>();
                for (int i=0;i<quotes2.size();i++) {
                    if(null==quotes2.get(i) || null == usIndia.get(i)){
                        continue;
                    }else{
                        series2.appendData(new DataPoint(Integer.parseInt(quotes2.get(i)),Double.parseDouble(usIndia.get(i))),true,90);
                    }

                }

                LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>();
                for (int i=0;i<quotes2.size();i++) {
                    if(null==quotes2.get(i) || null == usChina.get(i)){
                        continue;
                    }else{
                        series3.appendData(new DataPoint(Integer.parseInt(quotes2.get(i)),Double.parseDouble(usChina.get(i))),true,90);
                    }

                }

                graphView.setTitle("Macroeconomics Data");
                graphView.setTitleColor(R.color.purple_200);
                graphView.setTitleTextSize(18);

                GridLabelRenderer gridLabel1 = graphView.getGridLabelRenderer();
                gridLabel1.setHorizontalAxisTitle("Year");
                gridLabel1.setVerticalAxisTitle("USD");

                series1.setColor(Color.rgb(255,0,0));
                series2.setColor(Color.rgb(0,10,50));
                graphView.addSeries(series1);
                graphView.addSeries(series2);
                graphView.addSeries(series3);

                databaseAccess.close();
                    break;
            case R.id.radio_3:
                if (checked)
                    databaseAccess.open();
                List<String> quotes3 = databaseAccess.getGDPGrowthYear();
                List<String>  chinaList = databaseAccess.getGDPChina();


                graphView = findViewById(R.id.idGraphView);


                LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>();
                for (int i=0;i<quotes3.size();i++) {
                    if(null==quotes3.get(i) || null == chinaList.get(i)){
                        continue;
                    }else{
                        series4.appendData(new DataPoint(Integer.parseInt(quotes3.get(i)),Double.parseDouble(chinaList.get(i))),true,90);
                    }

                }



                graphView.setTitle("Macroeconomics Data");
                graphView.setTitleColor(R.color.purple_200);
                graphView.setTitleTextSize(18);

                GridLabelRenderer gridLabel2 = graphView.getGridLabelRenderer();
                gridLabel2.setHorizontalAxisTitle("Year");
                gridLabel2.setVerticalAxisTitle("USD");

                graphView.addSeries(series4);


                databaseAccess.close();

                break;
            case R.id.radio_4:
                if (checked)
                    databaseAccess.open();
                List<String> quotes4 = databaseAccess.getGDPGrowthYear();
                List<String> usIndia2 = databaseAccess.getGDPIndia();
                List<String> usChina2 = databaseAccess.getGDPChina();

                graphView = findViewById(R.id.idGraphView);


                LineGraphSeries<DataPoint> series5 = new LineGraphSeries<DataPoint>();
                for (int i=0;i<quotes4.size();i++) {
                    if(null==quotes4.get(i) || null == usChina2.get(i)){
                        continue;
                    }else{
                        series5.appendData(new DataPoint(Integer.parseInt(quotes4.get(i)),Double.parseDouble(usChina2.get(i))),true,90);
                    }

                }

                LineGraphSeries<DataPoint> series6 = new LineGraphSeries<DataPoint>();
                for (int i=0;i<quotes4.size();i++) {
                    if(null==quotes4.get(i) || null == usIndia2.get(i)){
                        continue;
                    }else{
                        series6.appendData(new DataPoint(Integer.parseInt(quotes4.get(i)),Double.parseDouble(usIndia2.get(i))),true,90);
                    }

                }


                series6.setColor(Color.rgb(255,0,0));
                graphView.setTitle("Macroeconomics Data");
                graphView.setTitleColor(R.color.purple_200);
                graphView.setTitleTextSize(18);

                GridLabelRenderer gridLabel3 = graphView.getGridLabelRenderer();
                gridLabel3.setHorizontalAxisTitle("Year");
                gridLabel3.setVerticalAxisTitle("USD");

                graphView.addSeries(series5);
                graphView.addSeries(series6);


                databaseAccess.close();
                    break;
        }
    }
}
