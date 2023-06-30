package com.example.myapplication.love;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.filmlist.Film;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class LoveActivity extends AppCompatActivity {
    ListView listView;

    static ArrayList<Film> loveData = Love.getLoveData();

    static LoveAdapter adapter;
    public static FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        listView = findViewById(R.id.listView);

        adapter = new LoveAdapter(this, getListUser());
        listView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setData();
    }

    public static ArrayList<Film> setData(){
        db.collection("love")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        loveData.clear();
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                Film love = new Film(1, document.getString("resourceImage"),document.getString("name"), document.getId());
                                loveData.add(love);
                            }
                            adapter.setData(loveData);
                        }
                    }
                });

        return null;
    }

    public static ArrayList<Film> getData(){
        db.collection("love")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        loveData.clear();
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                Film love = new Film(1, document.getString("resourceImage"),document.getString("name"), document.getString("resourceVideo"));
                                loveData.add(love);
                            }
                        }
                    }
                });

        return loveData;
    }
    private ArrayList<Film> getListUser(){
        Film user = new Film(1, "https://firebasestorage.googleapis.com/v0/b/netflix-73cc1.appspot.com/o/2022-03-01%20(1).png?alt=media&token=d49c560e-624f-4145-82eb-a482833137d7", "User1","https://firebasestorage.googleapis.com/v0/b/netflix-73cc1.appspot.com/o/film2.mp4?alt=media&token=7fcf16c1-c5fb-42f1-af53-4ef85dc6b258");
        if (!loveData.contains(user)) {
            // Nếu chưa tồn tại, thêm giá trị vào danh sách
            loveData.add(user);
        }
        return loveData;
    }
}