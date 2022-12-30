package com.example.test6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class signup extends Activity {
    Spinner spinner ;
    Button btnprev;
    Button btnnext;


    @Override

        protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);
            spinner = (Spinner) findViewById(R.id.spinner);
            btnprev = (Button) findViewById(R.id.btnprev);
            btnnext = (Button) findViewById(R.id.btnnext);

            //Création d'une liste d'élément à mettre dans le Spinner(pour l'exemple)
            List listeCategory= new ArrayList();
            listeCategory.add("Business Category");
            listeCategory.add("Business Category 2");
            listeCategory.add("Business Category 3");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner,listeCategory);
            spinner.setAdapter(adapter);


            btnprev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(signup.this, MainActivity.class));
                }
            });
            btnnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(signup.this, ServicePhysical.class));
                }
            });
        }
}