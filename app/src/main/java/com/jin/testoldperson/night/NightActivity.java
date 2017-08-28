package com.jin.testoldperson.night;

import android.content.res.Configuration;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jin.testoldperson.R;
import com.jin.testoldperson.scroller.CustomView;
import com.jin.testoldperson.scroller.ViewPagerScroller;

import java.util.ArrayList;
import java.util.List;

public class NightActivity extends AppCompatActivity {

    private int mode;
    private CustomView customView;


    private ViewPager viewPager;
    private List<View> views;
    private ViewPagerScroller pagerScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);
        mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        customView = (CustomView) findViewById(R.id.custom);

        pagerScroller=new ViewPagerScroller(this);
        views=new ArrayList<>();
        TextView textView=null;
        for(int i=0;i<4;i++){
            textView=new TextView(this);
            textView.setText(i+"position 位置");
            views.add(textView);
        }

        viewPager = (ViewPager) findViewById(R.id.viewpage);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
               container.removeView(views.get(position));
            }
        });
        pagerScroller.setScrollDuration(5000);
        pagerScroller.initViewPagerScroll(viewPager);


    }

    public void changeTheme(View view) {
        if (mode == Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate
                    .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if (mode == Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate
                    .setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            // blah blah
        }
        recreate();
    }

    public void move(View view) {
        customView.smoothScrollBy(300, 0);
    }
}
