package com.an.trailers.api;

import com.an.trailers.data.remote.api.AlbumApiService;
import com.an.trailers.data.remote.model.AlbumApiResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class AlbumApiServiceTest extends ApiAbstract<AlbumApiService> {

    private AlbumApiService service;

    @Before
    public void initService() {
        this.service = createService(AlbumApiService.class);
    }

    @Test
    public void fetchMovieDetailsTest() throws IOException {
        enqueueResponse("test_movie_details.json");
        AlbumApiResponse albumApiResponse = service.fetchAlbumList().blockingFirst();
        Assert.assertEquals("artistName", albumApiResponse.getResults().get(0).getArtistName());
        Assert.assertEquals(348580754, albumApiResponse.getResults().get(0).getArtistId());
    }

}
