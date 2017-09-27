package com.jin.testoldperson.material;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jin.testoldperson.R;

public class BottomSheetActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheetBehavior;
    private View roubdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        roubdView=findViewById(R.id.round);
        findViewById(R.id.btn_bottom_sheet_control).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 AnmUtils.roundLoadBig(roubdView);
                if (v.getId() == R.id.btn_bottom_sheet_control) {
                    if ( mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                       // mShowBottomSheet.setText(R.string.hide_bottom_sheet);
                    } else {
                        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                        //mShowBottomSheet.setText(R.string.show_bottom_sheet);
                    }
                }
            }
        });
        // 拿到这个tab_layout对应的BottomSheetBehavior
        mBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.tab_layout));
       // mBottomSheetBehavior .setState(BottomSheetBehavior.STATE_HIDDEN);
    }
}

