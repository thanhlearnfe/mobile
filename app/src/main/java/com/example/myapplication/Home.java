package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.filmlist.Film;
import com.example.myapplication.filmlist.FilmAdapter;
import com.example.myapplication.love.LoveActivity;
import com.example.myapplication.user.Login;
import com.example.myapplication.user.SignUp;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView rcvUser;
    private FilmAdapter mUserAdapter;
    private ImageView addFilm,detailFilm,yeuThich;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvUser = findViewById(R.id.rcv_user);
        mUserAdapter = new FilmAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        rcvUser.setLayoutManager(gridLayoutManager);

        mUserAdapter.setData(getListUser());
        rcvUser.setAdapter(mUserAdapter);



        addFilm = (ImageView) findViewById(R.id.imageView4);
        detailFilm = (ImageView) findViewById(R.id.img_user);
        yeuThich = (ImageView) findViewById(R.id.yeuthich);
        yeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, LoveActivity.class);
                startActivity(intent);

            }
        });

        addFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, VideoActivity.class);
                startActivity(intent);

            }
        });

    }

    private List<Film> getListUser(){
        List<Film> list = new ArrayList<>();

        list.add(new Film(1,R.drawable.t_img1,"User1"));
        list.add(new Film(2,R.drawable.t_img2,"User2"));
        list.add(new Film(3,R.drawable.t_img3,"User3"));
        list.add(new Film(4,R.drawable.t_img4,"User4"));
        list.add(new Film(5,R.drawable.t_img5,"User5"));
        list.add(new Film(6,R.drawable.t_img6,"User6"));
        list.add(new Film(7,R.drawable.t_img7,"User7"));
        return list;
    }
}