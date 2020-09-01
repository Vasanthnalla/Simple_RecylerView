package com.an.trailers.ui.album.activity;

import android.databinding.DataBindingUtil;
import android.support.v4.view.ViewCompat;
import android.os.Bundle;

import com.an.trailers.R;
import com.an.trailers.data.remote.model.ResultsItem;
import com.an.trailers.databinding.AlbumDeatilBinding;
import com.an.trailers.factory.ViewModelFactory;
import com.an.trailers.ui.base.BaseActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class AlbumDetailActivity extends BaseActivity {
    @Inject
    ViewModelFactory viewModelFactory;

    private AlbumDeatilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        AndroidInjection.inject(this);
        initialiseView();
           }
    private void initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.album_detail);

        ResultsItem album = getIntent().getParcelableExtra(INTENT_ALBUM);
        Picasso.get().load(album.getArtworkUrl100()).into(binding.productImage);
//        ViewCompat.setTransitionName(binding.productImage, TRANSITION_IMAGE_NAME);
        binding.productName.setText("Track Name: "+album.getTrackName());
        binding.toolbar.setText(album.getTrackName());
        binding.categoryDiscount.setText("Artist Name: "+album.getArtistName());
        binding.productDescription.setText("Collection Name: "+album.getCollectionName());
        binding.collectionPrice.setText("Collection Price: "+album.getCollectionPrice());
        binding.hotOffers.setText("Release Date: "+album.getReleaseDate());
        binding.bestValue.setText("Description: "+album.getLongDescription());
        //binding.expandButton.setPaintFlags(binding.expandButton.getPaintFlags() |  Paint.UNDERLINE_TEXT_FLAG);
    }
}