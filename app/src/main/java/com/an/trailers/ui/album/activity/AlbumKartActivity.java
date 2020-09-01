package com.an.trailers.ui.album.activity;

import android.app.SearchManager;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.an.trailers.R;
import com.an.trailers.data.remote.model.AlbumApiResponse;
import com.an.trailers.data.remote.model.ResultsItem;
import com.an.trailers.databinding.AlbumKartListBinding;
import com.an.trailers.databinding.AlbumListBinding;
import com.an.trailers.factory.ViewModelFactory;
import com.an.trailers.ui.album.adapter.AlbumKartListAdapter;
import com.an.trailers.ui.album.adapter.AlbumListAdapter;
import com.an.trailers.ui.album.viewmodel.AlbulmKartViewModel;
import com.an.trailers.ui.album.viewmodel.AlbumListViewModel;
import com.an.trailers.ui.base.BaseActivity;
import com.an.trailers.ui.base.custom.recyclerview.RecyclerItemClickListener;
import com.an.trailers.utils.NavigationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class AlbumKartActivity extends BaseActivity {
    @Inject
    ViewModelFactory viewModelFactory;
    AlbulmKartViewModel albumKartViewModel;
    private AlbumKartListBinding binding;
    private AlbumKartListAdapter albumListAdapter;
    List<ResultsItem> items = new ArrayList<>();
    String sort_type = "artist";
    AlbumListActivity albumListActivity = new AlbumListActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        initialiseView();
        initialiseViewModel();
    }
    private void initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_album_kart);
        albumListAdapter = new AlbumKartListAdapter(this);
        binding.albumList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.albumList.setAdapter(albumListAdapter);
    }
    private void initialiseViewModel() {
        albumKartViewModel = ViewModelProviders.of(this, viewModelFactory).get(AlbulmKartViewModel.class);
        displayLoader();
        albumKartViewModel.loadKartAlbums();
        albumKartViewModel.getKartlbumsLiveData().observe(this, resource -> {
            if(resource.isLoading()) {

            } else if(!resource.data.isEmpty()) {
                updateAlbumsList(resource.data);
            } else {
                handleErrorResponse();
            }
        });

    }
    private void updateAlbumsList(List<ResultsItem> items) {
        hideLoader();
        binding.emptyLayout.emptyContainer.setVisibility(View.GONE);
        binding.albumList.setVisibility(View.VISIBLE);
        TreeSet<ResultsItem> set=new TreeSet(items);
        items.clear();
        items.addAll(set);
        albumListAdapter.setItems(items,sort_type);
    }
    private void handleErrorResponse() {
        hideLoader();
        binding.albumList.setVisibility(View.GONE);
        binding.emptyLayout.emptyContainer.setVisibility(View.VISIBLE);

    }


    private void displayLoader() {
        binding.albumList.setVisibility(View.GONE);
        binding.loaderLayout.rootView.setVisibility(View.VISIBLE);
        binding.loaderLayout.loader.start();

    }

    private void hideLoader() {
        binding.albumList.setVisibility(View.VISIBLE);
        binding.loaderLayout.rootView.setVisibility(View.GONE);
        binding.loaderLayout.loader.stop();

    }
}