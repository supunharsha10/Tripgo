package com.example.devruwanrathnayake.trip_plan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TransportForm extends AppCompatActivity {

    DatabaseReference databaseReference;
    tform form;
    EditText HotelName, NIC, customerName, email, tp, passenger, type, in, out;
    Button btnSave;

    private void clearControls() {
        customerName.setText("");
        email.setText("");
        tp.setText("");
        type.setText("");
        passenger.setText("");
        in.setText("");
        out.setText("");
        NIC.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customerName = findViewById(R.id.txtName);
        tp = findViewById(R.id.txtMob);
        email = findViewById(R.id.txtEmail);
        passenger = findViewById(R.id.txthow);
        type = findViewById(R.id.txttype);
        in = findViewById(R.id.txtin);
        out = findViewById(R.id.txtcheckout);
        btnSave = findViewById(R.id.btnSend);
        NIC = findViewById(R.id.txtnic);
        form = new tform();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransportForm.this, userdetails.class);
                startActivity(intent);
            }


        });

        final Button send = (Button) findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Transport");
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
                    else if(TextUtils.isEmpty(passenger.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Plase Enter number of passengers", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(NIC.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Plase Enter Your NIC", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        form.setCustomerName(customerName.getText().toString().trim());
                        form.setTp(tp.getText().toString().trim());
                        form.setEmail(email.getText().toString().trim());
                        form.setRooms(passenger.getText().toString().trim());
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
