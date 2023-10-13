package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Bai1 extends AppCompatActivity {
    // Bài1
    FloatingActionButton fab1;
    ImageView imageView1;
    Button btnBlink, btnRotate, btnFade, btnMove, btnSlide, btnZoom, btnBounce,
    btnSequence, btnTogether, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        addControls();
        addEvents();
    }

    public void addControls(){
        fab1  = (FloatingActionButton) findViewById(R.id.fab1);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        btnBlink = (Button) findViewById(R.id.btnBlink);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnFade = (Button) findViewById(R.id.btnFade);
        btnMove = (Button) findViewById(R.id.btnMove);
        btnSlide = (Button) findViewById(R.id.btnSlide);
        btnZoom = (Button) findViewById(R.id.btnZoom);
        btnBounce = (Button) findViewById(R.id.btnBounce);
        btnSequence = (Button) findViewById(R.id.btnSequence);
        btnTogether = (Button) findViewById(R.id.btnTogether);
        btnStop = (Button) findViewById(R.id.btnStopAnimation);
    }

    public void addEvents(){

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onBackPressed();}
        });

        btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                imageView1.startAnimation(animation);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                imageView1.startAnimation(animation);
            }
        });

        btnFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                imageView1.startAnimation(animation);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                imageView1.startAnimation(animation);
            }
        });

        btnSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
                imageView1.startAnimation(animation);
            }
        });

        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                imageView1.startAnimation(animation);
            }
        });

        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                imageView1.startAnimation(animation);
            }
        });

        btnSequence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequence);
                imageView1.startAnimation(animation);
            }
        });

        btnTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.together);
                imageView1.startAnimation(animation);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.clearAnimation();
            }
        });

    }
}