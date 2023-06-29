package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.user.Login;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView sign_in;
        sign_in = findViewById(R.id.sign_in);
        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.go_home);
        myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện click ở đây
                Intent myitent = new Intent(MainActivity.this,Home.class);
                startActivity(myitent);
            }
        });


        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginitent = new Intent(MainActivity.this, Login.class);
                startActivity((loginitent));
            }
        });
    }
}