package com.example.bloodbank;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class BloodBank extends AppCompatActivity {


    private ImageView logo;
    private TextView title;

    Animation firstAnimation, secAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);


        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);

        firstAnimation = AnimationUtils.loadAnimation(this, R.anim.first_animation);
        secAnimation = AnimationUtils.loadAnimation(this, R.anim.sec_animation);

        logo.setAnimation(firstAnimation);
        title.setAnimation(secAnimation);

        int sScreen = 4300;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BloodBank.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, sScreen);
    }
}