package com.an.trailers.di.module;

import com.an.trailers.ui.album.activity.AlbumDetailActivity;
import com.an.trailers.ui.album.activity.AlbumKartActivity;
import com.an.trailers.ui.album.activity.AlbumListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector()
    abstract AlbumListActivity contributeAlbumListActivity();

    @ContributesAndroidInjector()
    abstract AlbumDetailActivity contributeAlbumDetailActivity();

    @ContributesAndroidInjector()
    abstract AlbumKartActivity contributeAlbumKartActivity();
}