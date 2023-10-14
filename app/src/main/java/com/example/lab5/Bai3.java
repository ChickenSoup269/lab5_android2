package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class Bai3 extends AppCompatActivity {
    // Bài3
    FloatingActionButton fab3;
    ImageView imgViewBird, imgViewCloud, imgViewCloud2, imgViewBirdKill;
    Button btnJump2;
    ImageButton imgBtnUp2, imgBtnDown2, imgBtnLeft2, imgBtnRight2, imgBtnFast, imgBtnLow;
    public int screenWidth, screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        addControls();
        addEvents();
    }

    public void addControls(){
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        btnJump2 = (Button) findViewById(R.id.btnJump2);
        imgBtnUp2 = (ImageButton) findViewById(R.id.imgBtnUp2);
        imgBtnUp2 = (ImageButton) findViewById(R.id.imgBtnUp2);
        imgBtnDown2 = (ImageButton) findViewById(R.id.imgBtnDown2);
        imgBtnLeft2 = (ImageButton) findViewById(R.id.imgBtnLeft2);
        imgBtnRight2 = (ImageButton) findViewById(R.id.imgBtnRight2);
        imgBtnFast = (ImageButton) findViewById(R.id.imgBtnFast);
        imgBtnLow = (ImageButton) findViewById(R.id.imgBtnLow);
        imgViewBird = (ImageView) findViewById(R.id.imgViewBird);
        imgViewCloud = (ImageView) findViewById(R.id.imgViewCloud);
        imgViewCloud2 = (ImageView) findViewById(R.id.imgViewCloud2);
        imgViewBirdKill = (ImageView) findViewById(R.id.imgViewBridKill);
        imgViewBird.setBackgroundResource(R.drawable.animation);
        imgViewCloud.setBackgroundResource(R.drawable.animationclound);
        imgViewCloud2.setBackgroundResource(R.drawable.animationclound);
        imgViewBirdKill.setBackgroundResource(R.drawable.animation_bird_kill);

    }

    public void addEvents(){
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onBackPressed();}
        });

        btnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.jump);
                imgViewBird.startAnimation(animation);
            }
        });

        imgBtnUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
                imgViewBird.startAnimation(animation);
            }
        });

        imgBtnDown2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
                imgViewBird.startAnimation(animation);
            }
        });

        imgBtnLeft2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left);
                imgViewBird.startAnimation(animation);
            }
        });

        imgBtnRight2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right);
                imgViewBird.startAnimation(animation);
            }
        });

        imgBtnFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fast);
                imgViewBird.startAnimation(animation);
                Toast.makeText(Bai3.this,"hoooyehh!!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        imgBtnLow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.low);
                imgViewBird.startAnimation(animation);
                Toast.makeText(Bai3.this,"Chậm lại thôi nào",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // lấy kích thước màn hình
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;

        startBirdKillAnimation();
    }

    public void startBirdKillAnimation() {
        // Bắt đầu animation
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(imgViewBirdKill, "translationX", screenWidth, -imgViewBirdKill.getWidth());
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(imgViewBirdKill, "translationY", getRandomYPosition());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorX, objectAnimatorY);
        animatorSet.setDuration(6000);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();

        // Lặp lại sau 10s
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Bắt đầu lại animation
                startBirdKillAnimation();
            }
        }, 10000);
    }

    public float getRandomYPosition() {
        // Lấy một vị trí Y ngẫu nhiên trong khoảng imgViewCloud
        Random random = new Random();
        return random.nextFloat() * (imgViewCloud.getHeight() - imgViewBirdKill.getHeight());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        AnimationDrawable frameCloud = (AnimationDrawable) imgViewCloud.getBackground();
        AnimationDrawable frameCloud2 = (AnimationDrawable) imgViewCloud2.getBackground();
        AnimationDrawable frameBird = (AnimationDrawable) imgViewBird.getBackground();
        AnimationDrawable frameBirdKill = (AnimationDrawable) imgViewBirdKill.getBackground();

        if (hasFocus) {
            frameCloud.start();
            frameBird.start();
            frameBirdKill.start();
            frameCloud2.start();
        } else {
            frameCloud.stop();
            frameCloud2.stop();
            frameBird.stop();
            frameBirdKill.stop();
        }
    }
}