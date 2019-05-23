package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class TransportationActivity extends AppCompatActivity {

    private Animation disappearingMenu;
    private LinearLayout menuFrame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
        menuFrame = findViewById(R.id.transportMenuFrame);


    }

    public void gotoFillupLog(View view){

        disappearingMenu = AnimationUtils.loadAnimation(this, R.anim.dissapear_anim);
        menuFrame.startAnimation(disappearingMenu);

        TimerTask task = new TimerTask(){
            public void run(){
                Intent fillUpIntent = new Intent(TransportationActivity.this, FuelMileageDataEntryActivity.class);
                startActivity(fillUpIntent);

            }

        };
        Timer timer = new Timer();
        timer.schedule(task, 900);

    }

    public void gotoNearestCharging(View view){

        disappearingMenu = AnimationUtils.loadAnimation(this, R.anim.dissapear_anim);
        menuFrame.startAnimation(disappearingMenu);

        Intent nearestCharging = new Intent(this, RechargerNearMeActivity.class);
        startActivity(nearestCharging);
    }

    public void gotoReport(View view){

        disappearingMenu = AnimationUtils.loadAnimation(this, R.anim.dissapear_anim);
        menuFrame.startAnimation(disappearingMenu);

        Intent report = new Intent(this, TransportReportActivity.class);
        startActivity(report);
    }
}
