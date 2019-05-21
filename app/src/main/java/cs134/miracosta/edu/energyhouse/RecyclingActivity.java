package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * RecyclingActivity.java - Gives user a menu to navigate the Recycling activities
 *
 * @author Dennis La
 * @version 1.0
 */
public class RecyclingActivity extends AppCompatActivity {

    private static Intent sIntent;

    private ImageView landscapeImageView;
    private Animation fadeInAnimation;

    /**
     * Creates the activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycling);

        landscapeImageView = findViewById(R.id.landscapeImageView);

        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim);

        landscapeImageView.startAnimation(fadeInAnimation);

    }

    /**
     * Goes to WhereToRecycleActivity
     *
     * @param v where to recycle button
     */
    public void goToWhereToActivity(View v)
    {
        sIntent = new Intent(this, WhereToRecycleActivity.class);
        startActivity(sIntent);
    }

    /**
     * Goes to WhatGoesWhereActivity
     *
     * @param v what goes where button
     */
    public void goToGoesWhereActivity(View v)
    {
        sIntent = new Intent(this, WhatGoesWhereActivity.class);
        startActivity(sIntent);
    }

    /**
     * Goes to CalculateRecyclablesActivity
     *
     * @param v calculate recyclables button
     */
    public void goToCalcRecActivity(View v)
    {
        sIntent = new Intent(this, CalculateRecyclablesActivity.class);
        startActivity(sIntent);
    }

    /**
     * Goes to ImpactActivity
     *
     * @param v impact tracker button
     */
    public void gotToImpactActivity(View v)
    {
        sIntent = new Intent(this, ImpactActivity.class);
        startActivity(sIntent);
    }
}
