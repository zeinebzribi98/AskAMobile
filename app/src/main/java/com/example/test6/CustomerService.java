package com.example.test6;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CustomerService extends AppCompatActivity {
    Spinner spinner ;
    Button btnprev ;
    Button btnnext ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        spinner = (Spinner) findViewById(R.id.spinner);
        btnprev = (Button) findViewById(R.id.btnprev);
        btnnext = (Button) findViewById(R.id.btnnext);
        List listeCategory= new ArrayList();
        listeCategory.add("deal1");
        listeCategory.add("deal2");
        listeCategory.add("deal3");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                R.layout.spinner,
                listeCategory
        );
        spinner.setAdapter(adapter);
        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomerService.this, ServiceArea.class));
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(CustomerService.this, rewardRefferencesService.class));
            }
        });

    }
}