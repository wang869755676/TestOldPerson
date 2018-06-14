package com.jin.testoldperson.recyclerviewt;

import android.support.v7.widget.RecyclerView;

/**
 * Created by my on 2018/6/14.
 */

interface OnItemTouchCallbackListener {
    boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target);

    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction);
}
