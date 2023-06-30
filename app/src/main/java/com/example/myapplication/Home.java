package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.filmlist.Film;
import com.example.myapplication.filmlist.FilmAdapter;
import com.example.myapplication.love.LoveActivity;
import com.example.myapplication.search.Search;
import com.example.myapplication.video.VideoActivity;
import com.example.myapplication.shorts.ShortActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private RecyclerView rcvUser;
    private FilmAdapter mUserAdapter;
    private ImageView addFilm,detailFilm,yeuThich,search, shorts;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    List<Film> list = new ArrayList<>();
    ArrayList<Film> listLove = new ArrayList<>();

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvUser = findViewById(R.id.rcv_user);
        mUserAdapter = new FilmAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        rcvUser.setLayoutManager(gridLayoutManager);

        rcvUser.setAdapter(mUserAdapter);

        addFilm = (ImageView) findViewById(R.id.imageView4);
        detailFilm = (ImageView) findViewById(R.id.img_user);
        yeuThich = (ImageView) findViewById(R.id.yeuthich);
        search = (ImageView) findViewById(R.id.search);
        shorts = (ImageView) findViewById(R.id.imageView10);


        yeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, LoveActivity.class);
                startActivity(intent);

            }
        });
        shorts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, ShortActivity.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Search.class);
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
    @Override
    protected void onStart() {
        super.onStart();
        getData();
    }
    private List<Film> getData(){
        db.collection("listFilm")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                Film user = new Film(1, document.getString("resourceImage"),document.getString("name"), document.getString("resourceVideo"));
                                list.add(user);
                            }
                            mUserAdapter.setData(list);
                            mUserAdapter.setLove(LoveActivity.getData());
                        }else{
                            Toast.makeText(getApplicationContext(), "Data gagal di ambil!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        return list;
    }
//    private List<Film> getListUser(){
//
//
//        list.add(new Film(1,"https://firebasestorage.googleapis.com/v0/b/netflix-73cc1.appspot.com/o/2022-03-01%20(1).png?alt=media&token=d49c560e-624f-4145-82eb-a482833137d7","User1"));
//        list.add(new Film(2,"https://firebasestorage.googleapis.com/v0/b/netflix-73cc1.appspot.com/o/2022-03-01%20(1).png?alt=media&token=d49c560e-624f-4145-82eb-a482833137d7","User2"));
//        list.add(new Film(3,"https://firebasestorage.googleapis.com/v0/b/netflix-73cc1.appspot.com/o/2022-03-01%20(1).png?alt=media&token=d49c560e-624f-4145-82eb-a482833137d7","User3"));
//        list.add(new Film(4,"https://firebasestorage.googleapis.com/v0/b/netflix-73cc1.appspot.com/o/2022-03-01%20(1).png?alt=media&token=d49c560e-624f-4145-82eb-a482833137d7","User4"));
//        list.add(new Film(5,"https://firebasestorage.googleapis.com/v0/b/netflix-73cc1.appspot.com/o/2022-03-01%20(1).png?alt=media&token=d49c560e-624f-4145-82eb-a482833137d7","User5"));
//
//        return list;
//    }
}