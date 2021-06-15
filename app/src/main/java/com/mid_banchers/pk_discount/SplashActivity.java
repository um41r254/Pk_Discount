package com.mid_banchers.pk_discount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView imageView = findViewById(R.id.imageView3);

        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        imageView.startAnimation(myAnim);
        final Intent i = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    startActivity(i);
                    finish();
                }
            }

        };

        timer.start();


    }

}
