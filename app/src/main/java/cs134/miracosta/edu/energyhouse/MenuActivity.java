package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button energyButton;
    private Button recycleButton;
    private Button transportButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        energyButton = findViewById(R.id.energyButton);
        recycleButton = findViewById(R.id.recycleButton);
        transportButton = findViewById(R.id.transportButton);
    }

    public void switchToEnergy(View v){
        Intent energyIntent = new Intent(this, EnergyActivity.class);
        startActivity(energyIntent);
    }

    //switchToRecycle
    public void switchToRecycle(View v){
        Intent recyclingIntent = new Intent(this, RecyclingActivity.class);
        startActivity(recyclingIntent);
    }

    //switchToTransport
    public void switchToTransport(View v){
        Intent transportIntent = new Intent(this, TransportSetupActivity.class);
        startActivity(transportIntent);
    }

}
