package com.jin.testoldperson.material.transition;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.transition.ChangeBounds;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;

import com.jin.testoldperson.MainActivity;
import com.jin.testoldperson.R;

import java.util.ArrayList;
import java.util.List;

public class TransitionActivity extends Activity {

    private Scene scene0;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private final List<View> viewsToAnimate = new ArrayList<>();
    private boolean isScene2;
    private static final int DELAY = 100;
    ViewGroup sceneRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        sceneRoot = findViewById(R.id.root);
     /*   scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.activity_animations_scene1 this);
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.scene_2, this);
        scene1.setEnterAction(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(TransitionActivity.this,"进入sence1",Toast.LENGTH_SHORT).show();
            }
        });
        TransitionManager.go(scene1);*/
        scene0 = Scene.getSceneForLayout(sceneRoot, R.layout.activity_animations_scene0, this);
        scene0.setEnterAction(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < viewsToAnimate.size(); i++) {
                    View child = viewsToAnimate.get(i);
                    child.animate()
                            .setStartDelay(i * DELAY)
                            .scaleX(1)
                            .scaleY(1);

                }
            }
        });
        scene0.setExitAction(new Runnable() {
            @Override
            public void run() {
                TransitionManager.beginDelayedTransition(sceneRoot);
                View title = scene0.getSceneRoot().findViewById(R.id.scene0_title);
                title.setScaleX(0);
                title.setScaleY(0);
            }
        });


        scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.activity_animations_scene1, this);
        scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.activity_animations_scene2, this);
        scene3 = Scene.getSceneForLayout(sceneRoot, R.layout.activity_animations_scene3, this);
        scene4 = Scene.getSceneForLayout(sceneRoot, R.layout.activity_animations_scene4, this);

        View button1 = findViewById(R.id.sample3_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(scene1, new ChangeBounds());
            }
        });
        View button2 = findViewById(R.id.sample3_button2);
        View button3 = findViewById(R.id.sample3_button3);
        View button4 = findViewById(R.id.sample3_button4);
     /*   button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(scene2, TransitionInflater.from(TransitionActivity.this).
                        inflateTransition(R.transition.slide_and_changebounds));
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TransitionManager.go(scene3, TransitionInflater.from(TransitionActivity.this).
                        inflateTransition(R.transition.slide_and_changebounds_sequential));
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(scene4, TransitionInflater.from(TransitionActivity.this).
                        inflateTransition(R.transition.slide_and_changebounds_sequential_with_interpolators));
            }
        });*/

        viewsToAnimate.add(button1);
        viewsToAnimate.add(button2);
        viewsToAnimate.add(button3);
        viewsToAnimate.add(button4);

        TransitionManager.go(scene0, new ChangeBounds());
        foregroundService();
    }

    public void changeSence(View v) {
        TransitionManager.go(isScene2 ? scene1 : scene2, new ChangeBounds());
        isScene2 = !isScene2;


    }

    public void foregroundService() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Intent intent = new Intent(this, MainActivity.class);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_layout);
        Notification notification = builder.setSmallIcon(R.mipmap.ic_launcher)//通知的构建过程基本与默认相同
                .setContent(remoteViews)//在这里设置自定义通知的内容
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, notification);
    }


}
