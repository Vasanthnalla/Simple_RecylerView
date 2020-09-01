package com.an.trailers.data.remote.api;

import com.an.trailers.data.remote.model.AlbumApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AlbumApiService {
    @GET("search?term=all")
    Observable<AlbumApiResponse> fetchAlbumList();
}
