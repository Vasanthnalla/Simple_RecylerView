package com.an.trailers.ui.album.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.an.trailers.data.Resource;
import com.an.trailers.data.local.dao.AlbumDao;
import com.an.trailers.data.remote.model.ResultsItem;
import com.an.trailers.data.repository.AlbumKartRepository;
import com.an.trailers.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

public class AlbulmKartViewModel extends BaseViewModel {
    @Inject
    public AlbulmKartViewModel(AlbumDao albumDao) {
        albumKartRepository = new AlbumKartRepository(albumDao);
    }
    private AlbumKartRepository albumKartRepository;
    private MutableLiveData<Resource<List<ResultsItem>>> albumKartLiveData = new MutableLiveData<>();

    public void loadKartAlbums() {
        albumKartRepository.loadAlbumKart()
                .doOnSubscribe(disposable -> addToDisposable(disposable))
                .subscribe(resource -> getKartlbumsLiveData().postValue(resource));
    }
    public MutableLiveData<Resource<List<ResultsItem>>> getKartlbumsLiveData() {
        return albumKartLiveData;
    }
}
