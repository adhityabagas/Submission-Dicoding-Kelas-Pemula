package com.example.submissionpemula;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListCameraAdapter extends RecyclerView.Adapter<ListCameraAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<Camera> listCamera;
    private OnItemClickCallback onItemClickCallback;

    ArrayList<Camera> getListCamera() {
        return listCamera;
    }

    public void setListCameraAdapter(ArrayList<Camera> listCamera) {
        this.listCamera = listCamera;
    }

    ListCameraAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_camera, parent, false);
        return new ListViewHolder(viewItemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        Glide.with(context)
                .load(getListCamera().get(position).getPhoto())
                .apply(new RequestOptions().override(150,150))
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(holder.imgCamera);

        holder.tvName.setText(getListCamera().get(position).getName());
        holder.tvTypeCamera.setText(getListCamera().get(position).getType());
        holder.tvCameraPrice.setText(getListCamera().get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Camera camera = new Camera();
                onItemClickCallback.onItemClicked(listCamera.get(holder.getAdapterPosition()));
                camera.setPhoto(listCamera.get(holder.getAdapterPosition()).getPhoto());
                camera.setType(listCamera.get(holder.getAdapterPosition()).getType());
                camera.setName(listCamera.get(holder.getAdapterPosition()).getName());
                camera.setPrice(listCamera.get(holder.getAdapterPosition()).getPrice());
                camera.setDesc(listCamera.get(holder.getAdapterPosition()).getDesc());

                Intent intentDetail = new Intent(view.getContext(), DetailActivity.class);
                intentDetail.putExtra(DetailActivity.EXTRA_CAMERA, camera);
                view.getContext().startActivity(intentDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListCamera().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCamera;
        TextView tvName, tvTypeCamera, tvCameraPrice;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCamera = itemView.findViewById(R.id.img_icon);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvTypeCamera = itemView.findViewById(R.id.tv_item_jenis);
            tvCameraPrice = itemView.findViewById(R.id.tv_item_price);
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Camera data);
    }
}
