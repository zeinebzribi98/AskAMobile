package com.example.test6;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.widget.Toolbar;
//import android.widget.Toolbar;

import com.example.test6.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    ActivityMainBinding binding_nav;
    Spinner spinner ;
    ListView listview;
    String[] names = {"chris","zeineb","mehdi"};
    ArrayAdapter<String> arrayAdapter;
    Fragment info_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding_nav = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding_nav.getRoot());

        spinner = (Spinner) findViewById(R.id.spinner);
        List listeCategory= new ArrayList();
        listeCategory.add("Refer");
        listeCategory.add("Groups");
        listeCategory.add("Individuals");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mainspinner,listeCategory);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Groups"))
                {
                    startActivity(new Intent(MainActivity.this, Refer_groups.class));
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });







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
                    L.setVisibility(View.INVISIBLE);
                    break;
                case R.id.Home:
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    break;
                case R.id.Favorite:
                    replaceFragment(new FavoriteFragment());
                    L.setVisibility(View.INVISIBLE);
                    break;
            }
            return true;

        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button btn = (Button)findViewById(R.id.btnDBC);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DBC.class));
            }
        });








    }
    public void  init(){

    }

    private void replaceFragment(Fragment fragment){
      //  Log.d("TAG","click");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout_nav,fragment);
        fragmentTransaction.commit();
    }


}