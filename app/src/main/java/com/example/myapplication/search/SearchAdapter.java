package com.example.myapplication.search;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.video.VideoActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHoder> {
    Context context;
    ArrayList<ModelClass> arrayList;
    LayoutInflater layoutInflater;

    public SearchAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.item_file,parent,false);
        return new MyHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoder holder, int position) {
        ModelClass film = arrayList.get(position);
        holder.searchName.setText(arrayList.get(position).getSearchName());
        Picasso.get().load(film.getImg()).into(holder.img);

        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addViewClick(view,film,film.getVideo(),film.getSearchName());
            }
        });
    }
    private void addViewClick(View view, ModelClass p, String t,String text) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("currentUrl");
        myRef.setValue(t);
        System.out.println(t);
        Intent intent = new Intent(context, VideoActivity.class);
        intent.putExtra("title", text);
        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class MyHoder extends RecyclerView.ViewHolder {
        TextView searchName;
        ImageView img,ivAdd;
        public MyHoder(@NonNull View itemView) {
            super(itemView);
            searchName=itemView.findViewById(R.id.txt);
            img=itemView.findViewById(R.id.img);
            this.ivAdd = (ImageView)itemView.findViewById(R.id.img);

        }
    }
}
