package com.example.submissionpemula;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle( "About");
        setContentView(R.layout.activity_about);

        ImageView imgProfil = findViewById(R.id.img_photo_profil);

        Glide.with(this)
                .load(R.drawable.foto_profil)
                .apply(new RequestOptions())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(imgProfil);
    }
}
