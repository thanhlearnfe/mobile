package com.example.myapplication.love;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapplication.R;
import com.example.myapplication.filmlist.Film;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LoveAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Film> arrayList;
    private TextView serialNum, name, contactNum;
    private ImageView img,delete;
    public LoveAdapter(Context context, ArrayList<Film> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    public void setData(ArrayList<Film> list){
        this.arrayList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    convertView = LayoutInflater.from(context).inflate(R.layout.t_love_item, parent, false);
    serialNum = convertView.findViewById(R.id.serailNumber);
    serialNum.setText(" " + arrayList.get(position).getName());

    img = convertView.findViewById(R.id.img);
    delete = convertView.findViewById(R.id.delete);
    System.out.println(arrayList.get(position).getResourceImage());
    Picasso.get().load(arrayList.get(position).getResourceImage()).into(img);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                DocumentReference docRef = db.collection("love").document(arrayList.get(position).getResourceVideo());
                docRef.delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(context.getApplicationContext(), "Xóa phim khỏi ds yêu thích thành công", Toast.LENGTH_SHORT).show();
                                // Tải lại dữ liệu
                                reloadData();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Xóa thất bại
                            }
                        });
            }
        });

    return convertView;
}
    private void reloadData() {
        // Thực hiện lại việc lấy dữ liệu từ Cloud Firestore và cập nhật lại dữ liệu trong adapter
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("love")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Film> updatedData = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Tạo đối tượng Film từ dữ liệu Firestore
                                Film film = new Film(1, document.getString("resourceImage"), document.getString("name"), document.getId());
                                updatedData.add(film);
                            }
                            // Cập nhật dữ liệu trong adapter
                            arrayList.clear();
                            arrayList.addAll(updatedData);
                            notifyDataSetChanged();
                        } else {
                            // Xử lý khi có lỗi xảy ra
                        }
                    }
                });
    }
}
