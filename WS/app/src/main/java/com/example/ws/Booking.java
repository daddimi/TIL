package com.example.ws;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Booking extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActionBar actionBar;
    MapFragment mapFragment;
    WebFragment webFragment;
    EventFragment eventFragment;
    FragmentManager fragmentManager;
    SupportMapFragment supportMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        mapFragment = new MapFragment(this);
        webFragment = new WebFragment(this);
        eventFragment = new EventFragment(this);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framelayout,mapFragment);


        actionBar = getSupportActionBar();
        actionBar.hide();

        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.bottom1) {
                    fragmentManager.beginTransaction().replace(R.id.framelayout, mapFragment).commit();
                    //Toast.makeText(Booking.this, "", Toast.LENGTH_LONG).show();

                } else if(item.getItemId() == R.id.bottom2) {
                    fragmentManager.beginTransaction().replace(R.id.framelayout, webFragment).commit();
                    //Toast.makeText(Booking.this, "this is web page", Toast.LENGTH_LONG).show();

                } else if(item.getItemId() == R.id.bottom3) {
                    fragmentManager.beginTransaction().replace(R.id.framelayout,eventFragment).commit();
                    //Toast.makeText(Booking.this, "this is event page", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

    }
}