package com.ranzan.unit32evual.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ranzan.unit32evual.Api.ResultsItem;
import com.ranzan.unit32evual.Listner.ItemClickListener;
import com.ranzan.unit32evual.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<DataViewHolder> {
    private List<ResultsItem> list;
    private ItemClickListener itemClickListener;

    public Adapter(List<ResultsItem> list, ItemClickListener itemClickListener) {
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    public Adapter(List<ResultsItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new DataViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        ResultsItem resultsItem = list.get(position);
        holder.setData(resultsItem);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateDataList(List<ResultsItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }


}
