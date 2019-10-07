package com.example.submissionpemula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
                showToast(data);
            }
        });
    }

    private void showToast(Camera camera) {
        Toast.makeText(this, "Kamu memilih " + camera.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
