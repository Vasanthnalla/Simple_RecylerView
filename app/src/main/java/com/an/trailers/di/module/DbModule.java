package com.an.trailers.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import com.an.trailers.data.local.AppDatabase;
import com.an.trailers.data.local.dao.AlbumDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, "Entertainment.db")
                .allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    AlbumDao provideAlbumDao(@NonNull AppDatabase appDatabase) {
        return appDatabase.albumDao();
    }
}
