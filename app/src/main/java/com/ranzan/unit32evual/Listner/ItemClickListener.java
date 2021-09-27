package com.ranzan.unit32evual.Listner;

import com.ranzan.unit32evual.Api.ResultsItem;

public interface ItemClickListener {
    void onPlay(ResultsItem resultsItem,int position);
    void onPause(ResultsItem resultsItem,int position);
    void onDelete(ResultsItem resultsItem,int position);

}
