package com.example.hackathon_techsolider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Dashboard extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

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

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_1:
                if (checked)
                    break;
            case R.id.radio_2:
                if (checked)
                    break;
            case R.id.radio_3:
                if (checked)
                    break;
            case R.id.radio_4:
                if (checked)
                    break;
        }
    }
}
