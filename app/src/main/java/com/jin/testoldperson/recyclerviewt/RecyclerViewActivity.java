package com.jin.testoldperson.recyclerviewt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        rv.setItemAnimator(new DefaultItemAnimator());
        Adpter adpter = new Adpter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adpter);


    }

    private class Adpter extends RecyclerView.Adapter<Adpter.ViewHolder> {

        @Override
        public Adpter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.item,null));
        }

        @Override
        public void onBindViewHolder(Adpter.ViewHolder holder, int position) {
          //  holder.item.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            //public TextView item;

            public ViewHolder(View itemView) {
                super(itemView);
               // item = (TextView) itemView;
            }
        }
    }
}
