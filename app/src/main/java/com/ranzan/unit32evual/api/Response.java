package com.ranzan.unit32evual.api;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("resultCount")
	private int resultCount;

	@SerializedName("results")
	private List<ResultsItem> results;

	public int getResultCount(){
		return resultCount;
	}

	public List<ResultsItem> getResults(){
		return results;
	}
}