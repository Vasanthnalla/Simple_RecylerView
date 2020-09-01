package com.an.trailers.data.remote.model;

import java.util.List;

public class AlbumApiResponse{
	private int resultCount;
	private List<ResultsItem> results;

	public int getResultCount(){
		return resultCount;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public void setResults(List<ResultsItem> results) {
		this.results = results;
	}
}