package com.example.test6;

import android.content.Intent;
import android.os.Bundle;

import com.example.test6.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.test6.databinding.ActivityReferGroupsBinding;

public class Refer_groups extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityReferGroupsBinding binding;
    ActivityReferGroupsBinding binding_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityReferGroupsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button btn = (Button)findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refer_groups.this, MainActivity.class));
            }
        });

        binding_nav = ActivityReferGroupsBinding.inflate(getLayoutInflater());
        LinearLayout  L = (LinearLayout)findViewById(R.id.linearLayout);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomnavigation);
        binding_nav.bottomnavigation.setOnItemSelectedListener(item -> {
            Log.d("TAG","click");
            switch (item.getItemId()){
                case R.id.Account:
                    replaceFragment(new AccountFragment());
                    L.setVisibility(View.INVISIBLE);
                    break;
                case R.id.Search:
                    replaceFragment(new SearchFragment());
                    ///  LinearLayout  L1 = (LinearLayout)findViewById(R.id.linearLayout);
                    L.setVisibility(View.INVISIBLE);
                    break;
                case R.id.Home:
                    //replaceFragment(new HomeFragment());
                    LinearLayout L2 = (LinearLayout)findViewById(R.id.contact);
                    LinearLayout  L3 = (LinearLayout)findViewById(R.id.searchView_layout);
                    LinearLayout  L4 = (LinearLayout)findViewById(R.id.linearLayout);
                    LinearLayout  L5 = (LinearLayout)findViewById(R.id.settings);
                    L.setVisibility(View.VISIBLE);
                    L2.setVisibility(View.INVISIBLE);
                    L3.setVisibility(View.INVISIBLE);

                    break;
                case R.id.Favorite:
                    replaceFragment(new FavoriteFragment());
                    L.setVisibility(View.INVISIBLE);
                    break;
            }
            return true;

        });


        Button btn1 = (Button)findViewById(R.id.hotels);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Refer_groups.this, Groups_second.class));
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        //  Log.d("TAG","click");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_nav,fragment);
        fragmentTransaction.commit();
    }

}