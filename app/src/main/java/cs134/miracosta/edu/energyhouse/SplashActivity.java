package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Delay with timer

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent energyIntent = new Intent(SplashActivity.this, EnergyActivity.class);
                startActivity(energyIntent);

                finish();

            }
        };
    }
}
