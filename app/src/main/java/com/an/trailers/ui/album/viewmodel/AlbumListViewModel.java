package com.an.trailers.ui.album.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.an.trailers.data.Resource;
import com.an.trailers.data.remote.api.AlbumApiService;
import com.an.trailers.data.remote.model.AlbumApiResponse;
import com.an.trailers.data.repository.AlbumRepository;
import com.an.trailers.ui.base.BaseViewModel;

import javax.inject.Inject;

public class AlbumListViewModel extends BaseViewModel {

    @Inject
    public AlbumListViewModel(AlbumApiService albumApiService) {
        albumRepository = new AlbumRepository(albumApiService);
    }

    private AlbumRepository albumRepository;
    private MutableLiveData<Resource<AlbumApiResponse>> albumsLiveData = new MutableLiveData<>();

    public AlbumListViewModel() {

    }

    public void loadMorealbums() {
        albumRepository.loadAlbum()
                .doOnSubscribe(disposable -> addToDisposable(disposable))
                .subscribe(resource -> getAlbumsLiveData().postValue(resource));
    }

    public MutableLiveData<Resource<AlbumApiResponse>> getAlbumsLiveData() {
        return albumsLiveData;
    }
}

