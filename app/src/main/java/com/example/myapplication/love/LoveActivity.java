package com.example.myapplication.love;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.filmlist.Film;

import java.util.ArrayList;

public class LoveActivity extends AppCompatActivity {
    ListView listView;

    ArrayList<Film> loveData = Love.getLoveData();

    LoveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        listView = findViewById(R.id.listView);


        adapter = new LoveAdapter(this, loveData);
        listView.setAdapter(adapter);
    }
}