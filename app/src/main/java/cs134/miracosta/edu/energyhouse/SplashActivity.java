package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Delay with timer

        // Delay the activity with a TimerTask

        TimerTask task = new TimerTask(){
            public void run(){
                Intent musicIntent = new Intent(SplashActivity.this, MenuActivity.class);
                startActivity(musicIntent);
                // Finish the current activity (finish SplashActivity)
                finish();

            }

        };
        Timer timer = new Timer();
        timer.schedule(task, 1500);
    }
}
