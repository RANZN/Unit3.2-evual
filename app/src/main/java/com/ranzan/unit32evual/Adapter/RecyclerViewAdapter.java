package com.ranzan.unit32evual.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ranzan.unit32evual.R;
import com.ranzan.unit32evual.Api.ResultsItem;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private List<ResultsItem> list;

    public RecyclerViewAdapter(List<ResultsItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.setData(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView trackImage, play, pause, delete;
        private TextView trackName, artistName;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View v) {
            trackImage = v.findViewById(R.id.trackImage);
            trackName = v.findViewById(R.id.trackName);
            artistName = v.findViewById(R.id.artistName);
            pause = v.findViewById(R.id.pauseBtn);
            play = v.findViewById(R.id.playBtn);
            delete = v.findViewById(R.id.deleteBtn);
        }

        void setData(ResultsItem item) {
            Glide.with(trackImage).load(item.getTrackViewUrl()).placeholder(R.drawable.ic_image).into(trackImage);
            trackName.setText(item.getTrackName());
            artistName.setText(item.getArtistName());
        }
    }
}
