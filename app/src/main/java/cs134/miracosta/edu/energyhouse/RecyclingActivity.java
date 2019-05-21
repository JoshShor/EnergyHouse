package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class RecyclingActivity extends AppCompatActivity {

    private static Intent sIntent;

    private ImageView landscapeImageView;
    private Animation fadeInAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling);

        landscapeImageView = findViewById(R.id.landscapeImageView);

        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim);

        landscapeImageView.startAnimation(fadeInAnimation);

    }

    public void goToWhereToActivity(View v)
    {
        sIntent = new Intent(this, WhereToRecycleActivity.class);
        startActivity(sIntent);
    }

    public void goToGoesWhereActivity(View v)
    {
        sIntent = new Intent(this, WhatGoesWhereActivity.class);
        startActivity(sIntent);
    }

    public void goToCalcRecActivity(View v)
    {
        sIntent = new Intent(this, CalculateRecyclablesActivity.class);
        startActivity(sIntent);
    }

    public void gotToImpactActivity(View v)
    {
        sIntent = new Intent(this, ImpactActivity.class);
        startActivity(sIntent);
    }
}
