package com.example.test6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.test6.databinding.ActivityChangeAccountInfoBinding;

public class Change_account_info extends Activity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityChangeAccountInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChangeAccountInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button prev = (Button)findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Change_account_info.this, MainActivity.class));

            }
        });


    }

}