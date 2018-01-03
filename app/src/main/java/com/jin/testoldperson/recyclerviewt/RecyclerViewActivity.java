package com.jin.testoldperson.recyclerviewt;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

import com.jin.testoldperson.Process.LiveActivity;
import com.jin.testoldperson.R;
import com.jin.testoldperson.app.CheckApkExist;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rv;
    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CheckApkExist.getAllPagcke(getApplicationContext());
        setContentView(R.layout.activity_recycler_view);
        rv = (RecyclerView) findViewById(R.id.rv);
        datas = new ArrayList<>();
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");
        datas.add("1");

        rv.setItemAnimator(new DefaultItemAnimator());
        Adpter adpter = new Adpter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adpter);
        startService(new Intent(this, LiveActivity.class));


    }

    private class Adpter extends RecyclerView.Adapter<Adpter.ViewHolder> {

        @Override
        public Adpter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.item, null));
        }

        @Override
        public void onBindViewHolder(final Adpter.ViewHolder holder, int position) {
            holder.textView.setSelected(true);
            holder.switcher.removeAllViews();
            holder.switcher.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    final TextView tv = new TextView(RecyclerViewActivity.this);
                    //设置文字大小

                    //设置文字 颜色
                    tv.setTextColor(Color.BLACK);
                    tv.setSingleLine();
                    tv.setEllipsize(TextUtils.TruncateAt.END);
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    lp.gravity = Gravity.CENTER;
                    tv.setLayoutParams(lp);
                    //内容的点击事件
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                    return tv;
                }
            });
            holder.switcher.setCurrentText("rtgfdfgd");


        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            //public TextView item;
            private LinearLayout root;
            private TextView textView;
            private TextSwitcher switcher;

            public ViewHolder(View itemView) {
                super(itemView);
                // item = (TextView) itemView;
                root = (LinearLayout) itemView.findViewById(R.id.root);
                textView = (TextView) itemView.findViewById(R.id.tv);
                switcher = (TextSwitcher) itemView.findViewById(R.id.switcher);


            }
        }
    }
}
