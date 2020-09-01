package com.an.trailers.data.local.converter;

import android.arch.persistence.room.TypeConverter;

import com.an.trailers.data.remote.model.ResultsItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class AlbumKartListConverter {
    @TypeConverter
    public List<ResultsItem> fromString(String value) {
        Type listType = new TypeToken<List<ResultsItem>>() {}.getType();
        List<ResultsItem> albumEntities = new Gson().fromJson(value, listType);
        return albumEntities;
    }

    @TypeConverter
    public String fromList(List<ResultsItem> albumEntities) {
        return new Gson().toJson(albumEntities);
    }
}


