package com.jin.testoldperson.expand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ExpandableListView;

import com.jin.testoldperson.R;

import java.util.ArrayList;
import java.util.List;

public class ExpandListActivity extends AppCompatActivity {

    ExpandableListView listView;
    List<ExpandData> dataList;
    List<String> strings;
    ExpandAdapter expandAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list);
        listView = (ExpandableListView) findViewById(R.id.expand_list);
        dataList = new ArrayList<>();
        strings = new ArrayList<>();
        strings.add("child1");
        dataList.add(new ExpandData("group1", strings));
        strings.add("child2");
        dataList.add(new ExpandData("group2", strings));
        strings.add("child3");
        dataList.add(new ExpandData("group3", strings));
        strings.add("child4");
        dataList.add(new ExpandData("group4", strings));
        strings.add("child5");
        dataList.add(new ExpandData("group5", strings));
        strings.add("child6");
        dataList.add(new ExpandData("group6", strings));


        expandAdapter = new ExpandAdapter(dataList, this);
        listView.setAdapter(new ExpandAdapter(dataList, this));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e("===",keyCode+" 按键code");
        return super.onKeyDown(keyCode, event);
    }
}
