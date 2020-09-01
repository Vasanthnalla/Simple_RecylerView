package com.an.trailers.data.repository;

import android.support.annotation.NonNull;

import com.an.trailers.data.NetworkBoundResource;
import com.an.trailers.data.Resource;
import com.an.trailers.data.remote.api.AlbumApiService;
import com.an.trailers.data.remote.model.AlbumApiResponse;
import com.an.trailers.data.remote.model.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Observable;

@Singleton
public class AlbumRepository {
    private AlbumApiService albumApiService;
    List<ResultsItem> resultsItems = new ArrayList<>();
    AlbumApiResponse apiResponse = new AlbumApiResponse();

    public AlbumRepository(AlbumApiService albumApiService) {
        this.albumApiService = albumApiService;
    }

    public Observable<Resource<AlbumApiResponse>> loadAlbum() {
        return new NetworkBoundResource<AlbumApiResponse, AlbumApiResponse>() {

            @Override
            protected void saveCallResult(@NonNull AlbumApiResponse item) {
               resultsItems = item.getResults();
               apiResponse = item;
            }

            @Override
            protected boolean shouldFetch() {
                return true;
            }


            @Override
            protected Flowable<AlbumApiResponse> loadFromDb() {
                return Flowable.just(apiResponse);
            }

            @NonNull
            @Override
            protected Observable<Resource<AlbumApiResponse>> createCall() {
                return albumApiService.fetchAlbumList()
                        .flatMap(albumApiResponse -> Observable.just(albumApiResponse == null
                                ? Resource.error("", new AlbumApiResponse())
                                : Resource.success(albumApiResponse)));
            }
        }.getAsObservable();
    }
}
