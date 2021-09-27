package com.ranzan.unit32evual.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.unit32evual.R;
import com.ranzan.unit32evual.api.ResultsItem;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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

        }
    }
}
