package com.example.myapplication.filmlist;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.filmlist.FilmAdapter;
import com.example.myapplication.love.Love;
import com.example.myapplication.love.LoveActivity;
import com.example.myapplication.love.LoveData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ImageViewHolder>{
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private Context mContext;
    private List<Film> mListFilm;
    ArrayList<Film> loveData = Love.getLoveData();
//    public FilmAdapter(Context mContext) {
//        this.mContext = mContext;
//    }
    public FilmAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<Film> list){
        this.mListFilm = list;
        notifyDataSetChanged();
    }
    public void setLove(ArrayList<Film> list){
        loveData = list;
    }
    @NonNull
    @Override
    public FilmAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.t_image_item,parent,false);
        return new FilmAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.ImageViewHolder holder, int position) {
        Film film = mListFilm.get(position);
        if(film == null){
            return;
        }

        Picasso.get().load(film.getResourceImage()).into(holder.imgUser);
        holder.tvName.setText(film.getName());

        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addButtonClick(view,film,film.getName());
            }
        });
    }
    private void addButtonClick(View view,Film p,String t) {

        if (!loveData.contains(p)) {
            // Nếu chưa tồn tại, thêm giá trị vào danh sách
            db.collection("love")
                    .add(p)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(mContext.getApplicationContext(), "Đã thêm phim vào danh sách phim yêu thích!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(mContext.getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }else {
            Toast.makeText(mContext.getApplicationContext(), "Bạn đã thêm phim này vào mục ưu thích!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public int getItemCount() {
        if(mListFilm != null){
            return mListFilm.size();
        }
        return 0;
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgUser;
        private TextView tvName;

        public ImageView ivAdd;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imgUser = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.tvname);
            this.ivAdd = (ImageView)itemView.findViewById(R.id.addFilm);
        }
    }
}


