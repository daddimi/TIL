package com.example.ws;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Booking extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ActionBar actionBar;
    MapFragment mapFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        mapFragment = new MapFragment();
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
                    Toast.makeText(Booking.this, "this is map page", Toast.LENGTH_LONG).show();
                }
//                } else if(item.getItemId() == R.id.tab2) {
//                    fragmentManager.beginTransaction().replace(R.id.framelayout,fragment2).commit();
//                    Toast.makeText(MainActivity.this, "tab2", Toast.LENGTH_SHORT).show();
//                } else if(item.getItemId() == R.id.tab3) {
//                    fragmentManager.beginTransaction().replace(R.id.framelayout,fragment3).commit();
//                    Toast.makeText(MainActivity.this, "tab3", Toast.LENGTH_SHORT).show();
//                }
                return false;
            }
        });

    }
}