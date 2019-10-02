package com.example.devruwanrathnayake.trip_plan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HotelDetails extends AppCompatActivity {
    DatabaseReference databaseReference;
    form form;
    EditText NIC1, NIC, customerName, email, tp, rooms, type, in, out;
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
        NIC1.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
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
        NIC1 = findViewById(R.id.txtnic1);
        form = new form();
        final Button viewdetails = (Button) findViewById(R.id.btnview);
        viewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Hotel").child(NIC1.getText().toString().trim());
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(TextUtils.isEmpty(NIC1.getText().toString())){
                            Toast.makeText(getApplicationContext(), "Enter NIC to Continue", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.hasChildren()) {
                            customerName.setText(dataSnapshot.child("customerName").getValue().toString());
                            tp.setText(dataSnapshot.child("tp").getValue().toString());
                            email.setText(dataSnapshot.child("email").getValue().toString());
                            rooms.setText(dataSnapshot.child("rooms").getValue().toString());
                            type.setText(dataSnapshot.child("roomtype").getValue().toString());
                            in.setText(dataSnapshot.child("in").getValue().toString());
                            out.setText(dataSnapshot.child("out").getValue().toString());
                            NIC.setText(dataSnapshot.child("nic").getValue().toString());
                        } else {
                            Toast.makeText(getApplicationContext(), "No such NIC", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        final Button updatedetails = (Button) findViewById(R.id.btnupdate);
        updatedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference Upref = FirebaseDatabase.getInstance().getReference().child("Hotel");
                Upref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(NIC1.getText().toString().trim())){
                            form.setCustomerName(customerName.getText().toString().trim());
                            form.setTp(tp.getText().toString().trim());
                            form.setEmail(email.getText().toString().trim());
                            form.setRooms(rooms.getText().toString().trim());
                            form.setRoomtype(type.getText().toString().trim());
                            form.setIn(in.getText().toString().trim());
                            form.setOut(out.getText().toString().trim());
                            form.setNIC(NIC.getText().toString().trim());
                            databaseReference = FirebaseDatabase.getInstance().getReference().child("Hotel").child(NIC.getText().toString().trim());
                            databaseReference.setValue(form);
                            Toast.makeText(getApplicationContext(), "Your Booking Updated Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        final Button deletedetails = (Button) findViewById(R.id.btndelete);
        deletedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Hotel");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChild(NIC1.getText().toString().trim())){
                        databaseReference = FirebaseDatabase.getInstance().getReference().child("Hotel").child(NIC.getText().toString().trim());
                        databaseReference.removeValue();
                        clearControls();
                        Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }
                    else {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
