package com.example.myapplication.search;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.love.LoveActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList = new ArrayList<>();
    ArrayList<ModelClass> searchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.recycleView);
        searchView = findViewById(R.id.searchView);


        db.collection("listFilm")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                ModelClass modelClass = new ModelClass();
                                modelClass.setSearchName(document.getString("name"));
                                modelClass.setImg(document.getString("resourceImage"));
                                arrayList.add(modelClass);
                                SearchAdapter searchAdapter=new SearchAdapter(Search.this,arrayList);
                                recyclerView.setAdapter(searchAdapter);
                            }

                        }else{
                            Toast.makeText(getApplicationContext(), "Data gagal di ambil!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Search.this);
        recyclerView.setLayoutManager(layoutManager);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList=new ArrayList<>();
                if (query.length()>0){
                    for (int i=0; i<arrayList.size() ;i++){
                        if (arrayList.get(i).getSearchName().toUpperCase().contains(query.toUpperCase())){
                            ModelClass modelClass=new ModelClass();
                            modelClass.setSearchName(arrayList.get(i).getSearchName());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Search.this);
                    recyclerView.setLayoutManager(layoutManager);
                    SearchAdapter searchAdapter=new SearchAdapter(Search.this,searchList);
                    recyclerView.setAdapter(searchAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Search.this);
                    recyclerView.setLayoutManager(layoutManager);
                    SearchAdapter searchAdapter=new SearchAdapter(Search.this,arrayList);
                    recyclerView.setAdapter(searchAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList=new ArrayList<>();
                if (newText.length()>0){
                    for (int i=0; i<arrayList.size() ;i++){
                        if (arrayList.get(i).getSearchName().toUpperCase().contains(newText.toUpperCase())){
                            ModelClass modelClass=new ModelClass();
                            modelClass.setSearchName(arrayList.get(i).getSearchName());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Search.this);
                    recyclerView.setLayoutManager(layoutManager);
                    SearchAdapter searchAdapter=new SearchAdapter(Search.this,searchList);
                    recyclerView.setAdapter(searchAdapter);
                }
                else {
                    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Search.this);
                    recyclerView.setLayoutManager(layoutManager);
                    SearchAdapter searchAdapter=new SearchAdapter(Search.this,arrayList);
                    recyclerView.setAdapter(searchAdapter);
                }
                return false;
            }
        });
    }
}