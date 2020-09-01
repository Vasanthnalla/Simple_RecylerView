package com.an.trailers.data.repository;

import com.an.trailers.data.Resource;
import com.an.trailers.data.local.dao.AlbumDao;
import com.an.trailers.data.remote.model.ResultsItem;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AlbumKartRepository {
    private AlbumDao albumDao;
    public AlbumKartRepository(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }
    public Observable<Resource<List<ResultsItem>>> loadAlbumKart() {
        return Observable.just(Resource.success(albumDao.getKartAlbums()));
    }
}
