package com.example.sameroot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverActiviry extends Activity {
    EditText d_name, d_mobile, d_carno, d_carModel, d_carcompany, d_adhar, d_city;
    Button DriverButton;
    DatabaseReference DriverDbRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver);
        d_name = findViewById(R.id.D_name);
        d_carno = findViewById(R.id.C_number);
        d_carModel = findViewById(R.id.C_model);
        d_carcompany = findViewById(R.id.C_company);;
        d_adhar = findViewById(R.id.C_adhaar);
        d_city = findViewById(R.id.p_City);
        d_mobile = findViewById(R.id.Driver_mobile);
        DriverButton = findViewById(R.id.SubmitDriverButton);
        DriverDbRef = FirebaseDatabase.getInstance().getReference().child("Drivers");
        DriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertDriverData();
            }
        });
    }
    private void insertDriverData(){
        String ddname = d_name.getText().toString();
        String ddcarno = d_carno.getText().toString();
        String ddcarmodel = d_carModel.getText().toString();
        String ddcarcompany = d_carcompany.getText().toString();
        String ddadhar = d_adhar.getText().toString();
        String ddcity = d_city.getText().toString();
        String ddmobile = d_mobile.getText().toString();
        Driver ddriver = new Driver(ddname, ddcarno, ddcarmodel, ddcarcompany, ddadhar, ddcity, ddmobile, ddmobile);
        DriverDbRef.push().setValue(ddriver);
        Toast.makeText(DriverActiviry.this, "Data submitted!", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(DriverActiviry.this, MainActivity.class);
        startActivity(intent);
    }
}