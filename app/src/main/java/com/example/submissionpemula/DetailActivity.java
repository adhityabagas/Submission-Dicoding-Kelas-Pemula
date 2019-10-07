package com.example.submissionpemula;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_CAMERA = "EXTRA_CAMERA";
    ImageView imgDetailPhoto;
    TextView tvTextName, tvTextType, tvTextPrice, tvTextDesc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle( "Detail Camera");
        setContentView(R.layout.activity_detail);

        imgDetailPhoto = findViewById(R.id.img_icon_detail);
        tvTextName = findViewById(R.id.tv_item_name_detail);
        tvTextType = findViewById(R.id.tv_item_jenis_detail);
        tvTextPrice = findViewById(R.id.tv_item_price_detail);
        tvTextDesc = findViewById(R.id.tv_desc_detail);
        Camera camera = getIntent().getParcelableExtra(EXTRA_CAMERA);

        Glide.with(this)
                .load(camera.getPhoto())
                .apply(new RequestOptions())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(imgDetailPhoto);

        tvTextName.setText(camera.getName());
        tvTextType.setText(camera.getType());
        tvTextPrice.setText(camera.getPrice());
        tvTextDesc.setText(camera.getDesc());
    }
}
