package com.an.trailers.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import com.an.trailers.AppConstants;
import com.an.trailers.R;
import com.an.trailers.data.remote.model.ResultsItem;
import com.an.trailers.ui.album.activity.AlbumDetailActivity;
import com.an.trailers.ui.album.activity.AlbumKartActivity;


public class NavigationUtils implements AppConstants {

    public static void redirectToAlbumDetailScreen(Activity activity,
                                                   ResultsItem item) {
        Intent intent = new Intent(activity, AlbumDetailActivity.class);
        intent.putExtra(INTENT_ALBUM, item);
        activity.startActivity(intent);
    }

    public static void redirectToAlbumKartScreen(Activity activity) {
        Intent intent = new Intent(activity, AlbumKartActivity.class);
        activity.startActivity(intent);
    }

}
