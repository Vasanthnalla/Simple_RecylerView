package com.an.trailers.util;

import com.an.trailers.data.remote.model.AlbumApiResponse;
import com.an.trailers.data.remote.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;

public class MockTestUtil {


    public static AlbumApiResponse mockMovieApiResponse() {
        AlbumApiResponse movieApiResponse = new AlbumApiResponse();
        movieApiResponse.setResults(mockMovieList());
        return movieApiResponse;
    }


    public static List<ResultsItem> mockMovieList() {
        List<ResultsItem> movieEntities = new ArrayList<>();

        ResultsItem albumEntity1 = new ResultsItem();
        albumEntity1.setArtistId(12345);
        movieEntities.add(albumEntity1);

        ResultsItem albumEntity2 = new ResultsItem();
        albumEntity1.setArtistName("test");
        movieEntities.add(albumEntity2);

        return movieEntities;
    }

    public static ResultsItem mockMovie() {
        ResultsItem movieEntity = new ResultsItem();
        movieEntity.setArtistId(1234);
        movieEntity.setArtistName("type");
        return movieEntity;
    }

}