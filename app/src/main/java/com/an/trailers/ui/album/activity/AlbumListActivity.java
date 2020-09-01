package com.an.trailers.ui.album.activity;

import android.app.SearchManager;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.an.trailers.R;
import com.an.trailers.data.remote.model.ResultsItem;
import com.an.trailers.databinding.AlbumListBinding;
import com.an.trailers.factory.ViewModelFactory;
import com.an.trailers.ui.album.adapter.AlbumListAdapter;
import com.an.trailers.ui.album.viewmodel.AlbulmKartViewModel;
import com.an.trailers.ui.album.viewmodel.AlbumListViewModel;
import com.an.trailers.ui.base.BaseActivity;
import com.an.trailers.utils.NavigationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class AlbumListActivity extends BaseActivity {
    @Inject
    ViewModelFactory viewModelFactory;
    AlbumListViewModel albumListViewModel;
    AlbulmKartViewModel albumKartViewModel;
    private AlbumListBinding binding;
    private AlbumListAdapter albumListAdapter;
    List<ResultsItem> items = new ArrayList<>();
    List<ResultsItem> kartitems = new ArrayList<>();
    String sort_type = "releasedate";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        AndroidInjection.inject(this);
        initialiseView();
        initialiseViewModel();
    }
    private void initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_album_list);
        albumListAdapter = new AlbumListAdapter(this);
        binding.albumList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.albumList.setAdapter(albumListAdapter);
//        binding.albumList.addOnItemTouchListener(new RecyclerItemClickListener(AlbumListActivity.this, this::onItemClick));

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        binding.search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        binding.search.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        binding.search.setIconifiedByDefault(false);
//        binding.search.setOnQueryTextListener(this);
        EditText searchEditText = binding.search.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(android.R.color.white));
        searchEditText.setHintTextColor(getResources().getColor(android.R.color.white));
        Typeface myCustomFont = ResourcesCompat.getFont(getApplicationContext(), R.font.gt_medium);
        searchEditText.setTypeface(myCustomFont);

        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                albumListAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                albumListAdapter.getFilter().filter(query);
                return false;
            }
        });
        binding.addFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationUtils.redirectToAlbumKartScreen(AlbumListActivity.this);
            }
        });
    }


    private void initialiseViewModel() {
        albumListViewModel = ViewModelProviders.of(this, viewModelFactory).get(AlbumListViewModel.class);
        displayLoader();
        albumListViewModel.loadMorealbums();
        albumListViewModel.getAlbumsLiveData().observe(this, resource -> {
            if(resource.isLoading()) {

            } else if(!resource.data.getResults().isEmpty()) {
                updateAlbumsList(resource.data.getResults());
                binding.divider.setVisibility(View.VISIBLE);
                binding.sorting.setVisibility(View.VISIBLE);
            } else {
                binding.divider.setVisibility(View.GONE);
                binding.sorting.setVisibility(View.GONE);
                handleErrorResponse();
            }
        });
        kartupdateddetalsfetch();
        binding.sorting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.relSorting.getVisibility() == View.VISIBLE) {
                    binding.relSorting.setVisibility(View.GONE);
                }else {
                    binding.relSorting.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.sortArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sort_type = "artist";
                albumListAdapter.setItems(items,kartitems,sort_type);
            }
        });
        binding.sortTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort_type = "track";
                albumListAdapter.setItems(items,kartitems,sort_type);
            }
        });
        binding.sortCollectionprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort_type = "collectionprice";
                albumListAdapter.setItems(items,kartitems,sort_type);
            }
        });
    }

    private void updateAlbumsList(List<ResultsItem> albums) {
        hideLoader();
        binding.emptyLayout.emptyContainer.setVisibility(View.GONE);
        binding.albumList.setVisibility(View.VISIBLE);
        TreeSet<ResultsItem> set=new TreeSet(albums);
        items.addAll(set);
        if (kartitems.size()>0) {
            for (int i = 0; i < items.size(); i++) {
                items.get(i).setKart("Add");
                int item = items.get(i).getTrackId();
                for (int j = 0; j < kartitems.size(); j++) {
                    if (item == kartitems.get(j).getTrackId()) {
                        items.get(i).setKart("Remove");
                    }
                }
            }
        }else {
            for (int j = 0; j < items.size(); j++) {
                items.get(j).setKart("Add");
            }
        }
        albumListAdapter.setItems(items,kartitems,sort_type);
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

    public void kartupdateddetalsfetch(){
        albumKartViewModel = ViewModelProviders.of(this, viewModelFactory).get(AlbulmKartViewModel.class);
        albumKartViewModel.loadKartAlbums();
        albumKartViewModel.getKartlbumsLiveData().observe(this, resource -> {
            if(resource.isLoading()) {

            } else if(!resource.data.isEmpty()) {
                kartitems = resource.data;
            } else {
                handleErrorResponse();
            }
        });
    }
}