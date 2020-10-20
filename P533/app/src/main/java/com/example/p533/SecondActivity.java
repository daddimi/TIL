package com.example.p533;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Movie> list;
    LinearLayout secondLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        listView = findViewById(R.id.listView);
        secondLayout = findViewById(R.id.secondLayout);
        list = new ArrayList<>();
        getData();
    }

    public void getData() {

    }

}
