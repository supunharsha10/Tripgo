package com.example.devruwanrathnayake.trip_plan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class TransportBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_booking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton car = (ImageButton) findViewById(R.id.car);
        ImageButton bus = (ImageButton) findViewById(R.id.bus);
        ImageButton van = (ImageButton) findViewById(R.id.van);
        ImageButton motorbike = (ImageButton) findViewById(R.id.bike);
        ImageButton threewheel = (ImageButton) findViewById(R.id.threewheel);
        car.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TransportBooking.this,TransportForm.class);
                startActivity(intent);
            }
        });
        bus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TransportBooking.this,TransportForm.class);
                startActivity(intent);
            }
        });
        van.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TransportBooking.this,TransportForm.class);
                startActivity(intent);
            }
        });
        motorbike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TransportBooking.this,TransportForm.class);
                startActivity(intent);
            }
        });
        threewheel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TransportBooking.this,TransportForm.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransportBooking.this,userdetails.class);
                startActivity(intent);
            }
        });
    }

}
