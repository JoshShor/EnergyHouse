package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button solarButton;
    private Button recycleButton;
    private Button switchToTransport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        solarButton = findViewById(R.id.solarButton);
    }

    public void switchToSolar(View v){
        Intent solarIntent = new Intent(this, EnergyActivity.class);
        startActivity(solarIntent);
    }

    //switchToRecycle
    public void switchToRecycle(View v){
        Intent solarIntent = new Intent(this, EnergyActivity.class);
        startActivity(solarIntent);
    }

    //switchToTransport
    public void switchToTransport(View v){
        Intent solarIntent = new Intent(this, EnergyActivity.class);
        startActivity(solarIntent);
    }

}
