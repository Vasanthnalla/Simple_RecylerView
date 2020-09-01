package com.an.trailers.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.an.trailers.data.local.converter.AlbumKartListConverter;
import com.an.trailers.data.local.dao.AlbumDao;
import com.an.trailers.data.remote.model.ResultsItem;

@Database(entities = {ResultsItem.class}, version = 1,  exportSchema = false)
@TypeConverters({AlbumKartListConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract AlbumDao albumDao();


    private static volatile AppDatabase INSTANCE;
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, "Entertainment.db")
                .allowMainThreadQueries().build();
    }
}
