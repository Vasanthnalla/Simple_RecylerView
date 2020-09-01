package com.an.trailers.viewmodel;

import android.app.Application;
import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Observer;
import android.support.test.InstrumentationRegistry;

import com.an.trailers.data.Resource;
import com.an.trailers.data.remote.model.AlbumApiResponse;
import com.an.trailers.data.remote.model.ResultsItem;
import com.an.trailers.ui.album.viewmodel.AlbumListViewModel;
import com.an.trailers.util.MockTestUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class AlbumListViewModelTest {
    private AlbumListViewModel movieListViewModel;

    @Mock
    Observer<Resource<AlbumApiResponse>> observer;

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void init() {
        Application app =
                (Application) InstrumentationRegistry
                        .getTargetContext()
                        .getApplicationContext();
        movieListViewModel = new AlbumListViewModel();
    }

    @Test
    public void fetchMovies() {
        movieListViewModel.getAlbumsLiveData().observeForever(observer);

        assert(movieListViewModel.getAlbumsLiveData().getValue().isLoading());
        assert(movieListViewModel.getAlbumsLiveData().getValue().data == MockTestUtil.mockMovieList());
    }
}
