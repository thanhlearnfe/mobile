package com.example.myapplication.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList = new ArrayList<>();
    ArrayList<ModelClass> searchList;
    String[] searList = new String[]{"The Sea Beast", "Peaky Blinders", "The Umbrella Academy", "Keep Sweet,Pray,and Obey",
            "Keep Sweet,Pray,and Obey", "The King of Staten Island", "Blonde", "Heat", "HUSTLE", "Content Title","Black",
    "Home Alone","Friend","Extra","Phone","School","Island","My Love","Big Mouse","Squid Game"};
    int[] imgList = new int[]{R.drawable.p_img1, R.drawable.p_img2, R.drawable.p_img3, R.drawable.p_img4,
            R.drawable.p_img5, R.drawable.p_img6, R.drawable.p_img7, R.drawable.p_img8,
            R.drawable.p_img9, R.drawable.p_img10,R.drawable.p_img1, R.drawable.p_img2, R.drawable.p_img3, R.drawable.p_img4,
            R.drawable.p_img5,R.drawable.p_img6, R.drawable.p_img7, R.drawable.p_img8,
            R.drawable.p_img9, R.drawable.p_img10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.recycleView);
        searchView = findViewById(R.id.searchView);

        for (int i = 0; i < searList.length; i++) {
            ModelClass modelClass = new ModelClass();
            modelClass.setSearchName(searList[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);
        }
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Search.this);
        recyclerView.setLayoutManager(layoutManager);
        SearchAdapter searchAdapter=new SearchAdapter(Search.this,arrayList);
        recyclerView.setAdapter(searchAdapter);
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