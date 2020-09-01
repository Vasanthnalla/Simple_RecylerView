package com.an.trailers.ui.album.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.an.trailers.R;
import com.an.trailers.data.local.AppDatabase;
import com.an.trailers.data.local.dao.AlbumDao;
import com.an.trailers.data.remote.model.ResultsItem;
import com.an.trailers.databinding.AlbumListItemBinding;
import com.an.trailers.utils.NavigationUtils;
import com.an.trailers.utils.Singleton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlbumKartListAdapter extends RecyclerView.Adapter<AlbumKartListAdapter.CustomViewHolder> {

    private Activity activity;
    private List<ResultsItem> albums;
    private List<ResultsItem> albumsFiltered;
    private List<ResultsItem> kartAlbums;
    private AlbumDao albumDao;
    private AppDatabase appDatabase;


    public AlbumKartListAdapter(Activity activity) {
        this.activity = activity;
        this.albums = new ArrayList<>();
        this.albumsFiltered = new ArrayList<>();
        this.kartAlbums = new ArrayList<>();
        this.appDatabase = AppDatabase.getInstance(activity);

    }

    @NonNull
    @Override
    public AlbumKartListAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AlbumListItemBinding itemBinding = AlbumListItemBinding.inflate(layoutInflater, parent, false);
        AlbumKartListAdapter.CustomViewHolder viewHolder = new AlbumKartListAdapter.CustomViewHolder(itemBinding);
        return viewHolder;
    }

    public void setItems(List<ResultsItem> albums,String sort_type) {
        int startPosition = this.albums.size();
        this.albumsFiltered.clear();

        this.albumsFiltered.addAll(albums);

        if (sort_type.equalsIgnoreCase("releasedate")){
            Comparator<ResultsItem> cm1 = Comparator.comparing(ResultsItem::getReleaseDate);
            Collections.sort(this.albumsFiltered, cm1);
        }else if (sort_type.equalsIgnoreCase("artist")){
            Comparator<ResultsItem> cm1 = Comparator.comparing(ResultsItem::getArtistName);
            Collections.sort(this.albumsFiltered, cm1);
        }else if (sort_type.equalsIgnoreCase("track")){
            Comparator<ResultsItem> cm1 = Comparator.comparing(ResultsItem::getTrackName);
            Collections.sort(this.albumsFiltered, cm1);
        }else if (sort_type.equalsIgnoreCase("collectioname")){
            Comparator<ResultsItem> cm1 = Comparator.comparing(ResultsItem::getCollectionName);
            Collections.sort(this.albumsFiltered, cm1);
        }else if (sort_type.equalsIgnoreCase("collectionprice")){
            Comparator<ResultsItem> cm1 = Comparator.comparing(ResultsItem::getCollectionPrice);
            Collections.sort(this.albumsFiltered, cm1);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return albumsFiltered.size();
    }

    public ResultsItem getItem(int position) {
        return albumsFiltered.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumKartListAdapter.CustomViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }



    protected class CustomViewHolder extends RecyclerView.ViewHolder {

        private AlbumListItemBinding binding;
        public CustomViewHolder(AlbumListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(ResultsItem album) {
            Picasso.get().load(album.getArtworkUrl100())
                    .placeholder(R.drawable.ic_placeholder)
                    .into(binding.productThumb);
            binding.itemName.setText(album.getArtistName());
            binding.itemShortDesc.setText(album.getTrackName());
            binding.itemPriceStrike.setText(album.getCollectionName());
            binding.itemPrice.setText(""+album.getCollectionPrice());
            binding.addItemBox.setText("Remove");

            binding.addItemBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appDatabase.albumDao().deleteAlbus(album);
                    albumsFiltered.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
            binding.topIconDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavigationUtils.redirectToAlbumDetailScreen(activity, album);
                }
            });
        }
    }
}

