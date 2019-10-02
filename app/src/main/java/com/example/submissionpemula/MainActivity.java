package com.example.submissionpemula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvCamera;
    private ArrayList<Camera> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCamera = findViewById(R.id.rv_camera);
        rvCamera.setHasFixedSize(true);

        list.addAll(CamerasData.getLisData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCamera.setLayoutManager(new LinearLayoutManager(this));
        ListCameraAdapter listCameraAdapter = new ListCameraAdapter(this);
        listCameraAdapter.setListCameraAdapter(list);
        rvCamera.setAdapter(listCameraAdapter);
        listCameraAdapter.setOnItemClickCallback(new ListCameraAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Camera data) {

            }
        });
    }
}
