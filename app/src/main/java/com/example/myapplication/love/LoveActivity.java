package com.example.myapplication.love;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class LoveActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Love> arrayList = new ArrayList<>();
    LoveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        listView = findViewById(R.id.listView);

        arrayList.add(new Love(1, 987576443,"987576443"));
        arrayList.add(new Love(2, 987576443,"8787576768"));
        arrayList.add(new Love(3, 987576443,"65757657657"));

        adapter = new LoveAdapter(this, arrayList);
        listView.setAdapter(adapter);
    }
}