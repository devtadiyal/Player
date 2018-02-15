package com.example.saffron.player;

import android.view.View;

/**
 * Created by saffron on 2/15/2018.
 */

public interface ItemClickListener{
    public void onClick(View view,int position);
    public void onLongClick(View view,int position);
}

