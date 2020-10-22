package com.example.ws;

import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class MapFragment extends Fragment {

    Booking b;
    TextView txmap2;
    LocationManager locationManager;
    SupportMapFragment supportMapFragment;
    GoogleMap gmap;
    //alertdialog에 getActivity로 ,,,....

    public MapFragment(Booking b) {
        this.b = b;
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b.setContentView(R.layout.fragment_map);
        b.getSupportActionBar().hide();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_map, container, false);



        return viewGroup;
    }
}