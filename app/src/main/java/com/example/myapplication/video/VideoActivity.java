package com.example.myapplication.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.Home;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video);
        VideoView videoView = findViewById(R.id.video_view);

        String videoPath = "https://3dbooth.egal.vn/hungpv/buu-cuc-k9/video/Sequence%2002_1.mp4";

        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.play);
        myLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.nameFilm);
                videoView.start();
            }
        });
    }
}