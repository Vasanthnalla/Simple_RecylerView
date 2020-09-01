package com.an.trailers.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.an.trailers.factory.ViewModelFactory;
import com.an.trailers.ui.album.activity.AlbumDetailActivity;
import com.an.trailers.ui.album.viewmodel.AlbulmKartViewModel;
import com.an.trailers.ui.album.viewmodel.AlbumDetailViewModel;
import com.an.trailers.ui.album.viewmodel.AlbumListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);


    @Binds
    @IntoMap
    @ViewModelKey(AlbumListViewModel.class)
    protected abstract ViewModel albumListViewModel(AlbumListViewModel albumsListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AlbumDetailViewModel.class)
    protected abstract ViewModel albumDetailViewModel(AlbumDetailViewModel albumsDetailViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(AlbulmKartViewModel.class)
    protected abstract ViewModel albumKartViewModel(AlbulmKartViewModel albumsKartViewModel);
}