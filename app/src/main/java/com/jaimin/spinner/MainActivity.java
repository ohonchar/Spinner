package com.jaimin.spinner;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import java.util.Random;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner1);
        RelativeLayout rl = findViewById(R.id.rlVar1);

        final DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        Random R = new Random();
        final float dx = R.nextFloat() * displaymetrics.widthPixels;
        final float dy = R.nextFloat() * displaymetrics.heightPixels;
        spinner.animate()
                .x(dx)
                .y(dy)
                .setDuration(0)
                .start();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), adapterView.getItemAtPosition(i).toString(),
                        Toast.LENGTH_SHORT).show();
                try {
                    rl.setBackgroundColor(Color.parseColor(adapterView.getItemAtPosition(i).toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}