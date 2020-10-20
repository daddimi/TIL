package com.example.p675;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    SupportMapFragment supportMapFragment;
    GoogleMap gmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gmap = googleMap;
                LatLng latlng = new LatLng(34.250342, 108.925663);
                gmap.addMarker(new MarkerOptions().position(latlng).title("university"));
                gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,10));

            }
        });
    }

    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        LatLng latlng = new LatLng(34.250342, 108.925663);
        gmap.addMarker(new MarkerOptions().position(latlng).title("university"));
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,10));

    }


    public void ck1 (View v) {
        LatLng latlng = new LatLng(34.259502, 108.947003);
        gmap.addMarker(new MarkerOptions().position(latlng).title("tower bell").snippet("xxx").icon(BitmapDescriptorFactory.fromResource(R.drawable.kl)));
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,15));

    }

    public void ck2 (View v) {
        LatLng latlng = new LatLng(34.259052, 108.924998);
        gmap.addMarker(new MarkerOptions().position(latlng).title("park").snippet("xxx").icon(BitmapDescriptorFactory.fromResource(R.drawable.kl)));
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,5));
    }

}