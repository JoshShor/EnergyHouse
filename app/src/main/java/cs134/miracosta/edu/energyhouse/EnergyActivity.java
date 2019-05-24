package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class EnergyActivity extends AppCompatActivity {
    private Button applianceButton;
    private Button solarButton;
    private Animation shakeAnim;
    private ImageView eHLogoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);

        applianceButton = findViewById(R.id.applianceButton);
        solarButton = findViewById(R.id.solarButton);
        eHLogoImageView = findViewById(R.id.eHLogoImageView);
    }

    public void switchToAppliance(View v){
        Intent applianceIntent = new Intent(this, ApplianceActivity.class);
        startActivity(applianceIntent);
    }

    public void switchToSolar(View v){
        Intent solarIntent = new Intent(this, SolarActivity.class);
        startActivity(solarIntent);
    }

    public void toggleShakeAnim(View v){
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_animation);
        eHLogoImageView.startAnimation(shakeAnim);
    }
}