package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Bai2 extends AppCompatActivity {
    // Bài2
    FloatingActionButton fab2;
    Button btnJump;
    ImageButton imgBtnUp, imgBtnDown, imgBtnLeft, imgBtnRight;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        addControls();
        addEvents();
    }

    public void addControls(){
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        btnJump = (Button) findViewById(R.id.btnJump);
        imgBtnUp = (ImageButton) findViewById(R.id.imgBtnUp);
        imgBtnDown = (ImageButton) findViewById(R.id.imgBtnDown);
        imgBtnLeft = (ImageButton) findViewById(R.id.imgBtnLeft);
        imgBtnRight = (ImageButton) findViewById(R.id.imgBtnRight);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }

    public void addEvents(){
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onBackPressed();}
        });

        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.jump);
                imageView2.startAnimation(animation);
            }
        });

        imgBtnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
                imageView2.startAnimation(animation);
            }
        });

        imgBtnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
                imageView2.startAnimation(animation);
            }
        });

        imgBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left);
                imageView2.startAnimation(animation);
            }
        });

        imgBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right);
                imageView2.startAnimation(animation);
            }
        });

    }
}