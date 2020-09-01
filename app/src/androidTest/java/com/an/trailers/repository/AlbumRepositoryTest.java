package com.an.trailers.repository;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.an.trailers.data.Resource;
import com.an.trailers.data.remote.api.AlbumApiService;
import com.an.trailers.data.remote.model.AlbumApiResponse;
import com.an.trailers.data.repository.AlbumKartRepository;
import com.an.trailers.data.repository.AlbumRepository;
import com.an.trailers.util.MockTestUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlbumRepositoryTest {

    @Mock
    AlbumApiService movieApiService;

    private AlbumRepository repository;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void init() {
        repository = new AlbumRepository(movieApiService);
    }


    @Test
    public void loadMoviesList() {

        Flowable<AlbumApiResponse> loadFromDB = Flowable.empty();

        AlbumApiResponse mockResponse = MockTestUtil.mockMovieApiResponse();
        when(movieApiService.fetchAlbumList())
                .thenReturn(Observable.just(mockResponse));

        Observable<Resource<AlbumApiResponse>>
                data = repository.loadAlbum();

        verify(movieApiService).fetchAlbumList();

        TestObserver testObserver = new TestObserver();
        data.subscribe(testObserver);
        testObserver.assertNoErrors();
    }
}
