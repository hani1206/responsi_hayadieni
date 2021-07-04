package com.example.responsi_hayadieni.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_hayadieni.R;
import com.example.responsi_hayadieni.model.Rsakit.DataItem;

import java.util.List;

public class RsakitAdapter extends RecyclerView.Adapter<RsakitAdapter.ViewHolder>{

    List<DataItem> item;

    public RsakitAdapter(List<DataItem> item) {
        this.item = item;
    }

    @NonNull
    @Override
    public RsakitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_rs, parent, false);

        return new RsakitAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RsakitAdapter.ViewHolder holder, int position) {
        holder.bind(item.get(position));
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRS, tvAlamat;
        Button btnMaps;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRS = itemView.findViewById(R.id.tv_rs);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            btnMaps = itemView.findViewById(R.id.btn_maps);

        }

        void bind(DataItem item){
            tvRS.setText(item.getNama());
            tvAlamat.setText(item.getAlamat());
            btnMaps.setOnClickListener(v -> {
                String location = "geo:" + item.getLatitude() + "," + item.getLongitude() + "?q=";

                Uri gmmIntentUri = Uri.parse(location + Uri.encode(item.getNama()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                itemView.getContext().startActivity(mapIntent);
            });
        }
    }
}
