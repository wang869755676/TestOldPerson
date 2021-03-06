package com.jin.testoldperson.recyclerviewt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.jin.testoldperson.Process.LiveActivity;
import com.jin.testoldperson.R;
import com.jin.testoldperson.app.CheckApkExist;

import java.util.ArrayList;
import java.util.Collections;
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
        datas.add("2");
        datas.add("3");
        datas.add("5");
        datas.add("5");
        datas.add("6");
        datas.add("7");
        datas.add("8");
        datas.add("9");
        datas.add("10");
        datas.add("11");
        datas.add("12");


        rv.setItemAnimator(new DefaultItemAnimator());
        final Adpter adpter = new Adpter();
        rv.setLayoutManager(new GridLayoutManager(this,2));

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new CustomItemTouchHelperCallback(new OnItemTouchCallbackListener() {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                if (datas == null) {
                    return false;
                }
                //处理拖动排序
                //使用Collection对数组进行重排序，目的是把我们拖动的Item换到下一个目标Item的位置
                Collections.swap(datas, viewHolder.getAdapterPosition(), target.getAdapterPosition());
                //通知Adapter它的Item发生了移动
                adpter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;

            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                if (datas == null) {
                    return;
                }
                //处理滑动删除
                //直接从数据中删除该Item的数据
                datas.remove(viewHolder.getAdapterPosition());
                //通知Adapter有Item被移除了
                adpter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }


        }));
        itemTouchHelper.attachToRecyclerView(rv);

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
            holder.textView.setText(datas.get(position)+"fdgfcgdgdfgdfgd");
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK ||keyCode==KeyEvent.KEYCODE_HOME){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
