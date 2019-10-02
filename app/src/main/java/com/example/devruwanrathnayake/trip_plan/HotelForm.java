package com.example.devruwanrathnayake.trip_plan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class HotelForm extends AppCompatActivity {
    DatabaseReference databaseReference;
    form form;
    EditText HotelName, NIC, customerName, email, tp, rooms, type, in, out;
    Button btnSave;

    private void clearControls() {
        customerName.setText("");
        email.setText("");
        tp.setText("");
        type.setText("");
        rooms.setText("");
        in.setText("");
        out.setText("");
        NIC.setText("");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        customerName = findViewById(R.id.txtName);
        tp = findViewById(R.id.txtMob);
        email = findViewById(R.id.txtEmail);
        rooms = findViewById(R.id.txthow);
        type = findViewById(R.id.txttype);
        in = findViewById(R.id.txtin);
        out = findViewById(R.id.txtcheckout);
        btnSave = findViewById(R.id.btnSend);
        NIC = findViewById(R.id.txtnic);
        form = new form();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotelForm.this, userdetails.class);
                startActivity(intent);
            }


        });

        final Button send = (Button) findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Hotel");
                try {
                    if(TextUtils.isEmpty(customerName.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Plase Enter Your Name", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(tp.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Plase Enter Telephone Number", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(email.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Plase Enter Your email", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(rooms.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Plase Enter number of Rooms", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(NIC.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Plase Enter Your NIC", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        form.setCustomerName(customerName.getText().toString().trim());
                        form.setTp(tp.getText().toString().trim());
                        form.setEmail(email.getText().toString().trim());
                        form.setRooms(rooms.getText().toString().trim());
                        form.setRoomtype(type.getText().toString().trim());
                        form.setIn(in.getText().toString().trim());
                        form.setOut(out.getText().toString().trim());
                        form.setNIC(NIC.getText().toString().trim());
                        databaseReference.push().setValue(form);
                        databaseReference.child(NIC.getText().toString().trim()).setValue(form);
                        Toast.makeText(getApplicationContext(), "Your Booking added Successfully", Toast.LENGTH_SHORT).show();
                    }
                    } finally {
                    clearControls();
                }

        }
    });
}
}