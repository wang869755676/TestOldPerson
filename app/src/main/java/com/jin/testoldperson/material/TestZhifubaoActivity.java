package com.jin.testoldperson.material;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.LruCache;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jin.testoldperson.R;

public class TestZhifubaoActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private EditText ed;
    private TextView tv;
    private LinearLayout container;

    private ThreadLocal<TestHtreadLocal> threadLocal=new ThreadLocal<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_zhifubao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("");
        ed = (EditText) findViewById(R.id.ed);
        ed.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                menu.clear();
                inflater.inflate(R.menu.menu_test_zhifubao, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
     /*   tv = (TextView) findViewById(R.id.tv);
        tv.setCustomSelectionActionModeCallback(new ActionMode.Callback2() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                menu.clear();
                inflater.inflate(R.menu.menu_test_zhifubao, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });*/

        /*toast 的使用*/
     /*   Toast toast = new Toast(this);
        toast.setText("dfdsfsdfs");
        toast.show();*/
        /*缓存*/
       // LruCache

        /*本地线程*/
        TestHtreadLocal account = new  TestHtreadLocal ("初始名");
        threadLocal.set(account);
        new MyTest(account,"线程甲").start();
        new MyTest(account,"线程乙").start();

        /*android中的动态布局*/
        container= (LinearLayout) findViewById(R.id.container);
      /*  View view=LayoutInflater.from(this).inflate(R.layout.item_expnad_group,container);
        container.addView(view);*/


      /*android  handler*/
       // MessageQueue
        //Looper
       // Handler


    }

    class MyTest extends Thread{

        private TestHtreadLocal account;

        public MyTest(TestHtreadLocal account,String name){
            super(name);
            this.account = account;
        }

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                if(i==6){
                    account.setName(getName());
                }
                System.out.println(account.getName()+"账户i的值为:"+i);
            }
        }

    }
}
