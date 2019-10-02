package com.example.devruwanrathnayake.trip_plan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class HotelsBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_booking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton cinnamon = (ImageButton) findViewById(R.id.car);
        ImageButton taj = (ImageButton) findViewById(R.id.van);
        ImageButton shangrilla = (ImageButton) findViewById(R.id.bus);
        ImageButton amaya = (ImageButton) findViewById(R.id.bike);
        ImageButton galle = (ImageButton) findViewById(R.id.threewheel);



        cinnamon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HotelsBooking.this,HotelForm.class);
                startActivity(intent);
            }
        });
        taj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HotelsBooking.this,HotelForm.class);
                startActivity(intent);
            }
        });
        shangrilla.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HotelsBooking.this,HotelForm.class);
                startActivity(intent);
            }
        });
        amaya.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HotelsBooking.this,HotelForm.class);
                startActivity(intent);
            }
        });
        galle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HotelsBooking.this,HotelForm.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotelsBooking.this,userdetails.class);
                startActivity(intent);
            }
        });
    }


}
