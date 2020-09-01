package com.an.trailers.db;

import android.support.test.runner.AndroidJUnit4;

import com.an.trailers.data.remote.model.ResultsItem;
import com.an.trailers.util.MockTestUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;



@RunWith(AndroidJUnit4.class)
public class AlbumDaoTest extends DbTest {

    @Test
    public void insertAndReadMovieTest() {
        List<ResultsItem> albumEntities = new ArrayList<>();
        albumEntities.add(MockTestUtil.mockMovie());

        db.albumDao().insertAlbums(albumEntities.get(0));
        List<ResultsItem> storedMovieEntities = db.albumDao().getKartAlbums();
        Assert.assertEquals(1234, storedMovieEntities.get(0).getArtistId());
        Assert.assertEquals("type", storedMovieEntities.get(0).getArtistName());
    }

}
