package com.an.trailers.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.an.trailers.data.remote.model.ResultsItem;

import java.util.List;

@Dao
public interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlbums(ResultsItem albums);

    @Delete
    void deleteAlbus(ResultsItem album);

    @Query("SELECT * FROM `ResultsItem` ORDER BY artistId")
    List<ResultsItem> getKartAlbums();
}
