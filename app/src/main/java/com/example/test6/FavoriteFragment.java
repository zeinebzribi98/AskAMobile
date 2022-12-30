package com.example.test6;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {


    public FavoriteFragment() {
        // Required empty public constructor
    }


    public static FavoriteFragment newInstance(String param1, String param2) {
        FavoriteFragment fragment = new FavoriteFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        String[] names = {"aaaa","bbbb"};
        String[] messages = {"aaaa","bbbb"};

        ArrayList<Favorites> fav = new ArrayList<>();

        for(int i = 0; i<names.length; i++){
            Favorites fave = new Favorites(names[i], messages[i]);
            fav.add(fave);
        }

       // Log.d("LGO FAV", String.valueOf(fav.size()));

      //  ListAdapter listAdapter = new listAdaptater(getContext(), fav);
        View view =  inflater.inflate(R.layout.fragment_favorite, container, false);

        //ListView.setAdapter(listAdapter);

        ArrayList<Favorites> arrayOfUsers = new ArrayList<Favorites>();
        // Create the adapter to convert the array to views
        listAdaptater adapter = new listAdaptater(getContext(), arrayOfUsers);
        // Attach the adapter to a ListView
       // ListView listView = (ListView) findViewById(R.id.lvItems);
        ListView listView = (ListView) view.findViewById(R.id.listview);

        listView.setAdapter(adapter);




        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }
}