package com.example.myapplication.filmlist;

import android.content.Context;
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

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ImageViewHolder>{

    private Context mContext;
    private List<Film> mListFilm;

    public FilmAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Film> list){
        this.mListFilm = list;
        notifyDataSetChanged();
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

        holder.imgUser.setImageResource(film.getResourceImage());
        holder.tvName.setText(film.getName());

        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addButtonClick(view,film,film.getName());
            }
        });
    }
    private void addButtonClick(View view,Film p,String t) {
        Toast toast = Toast.makeText(mContext.getApplicationContext(),"wef"+t, Toast.LENGTH_SHORT);
        toast.show();
        Love.addFilm(p);
//        Love.setLoveData();
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
            this.ivAdd = (ImageView)itemView.findViewById(R.id.img_user);
        }
    }
}


