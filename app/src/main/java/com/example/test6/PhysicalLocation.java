package com.example.test6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.test6.databinding.ActivityPhysicalLocationBinding;

public class PhysicalLocation extends Activity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPhysicalLocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPhysicalLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button btnprev = (Button)findViewById(R.id.btnprev);
        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PhysicalLocation.this, ServicePhysical.class));
            }
        });

    }


}