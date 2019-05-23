package cs134.miracosta.edu.energyhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PowerEstimate extends AppCompatActivity {
    private TextView energyDailyTextView;
    private TextView energyWeeklyTextView;
    private TextView energyMonthlyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_estimate);

        energyDailyTextView = findViewById(R.id.energyDailyTextView);
        energyWeeklyTextView = findViewById(R.id.energyWeeklyTextView);
        energyMonthlyTextView = findViewById(R.id.energyMonthlyTextView);

        Intent intent = getIntent();

        energyDailyTextView.setText(intent.getStringExtra("DailyNRG"));
        energyWeeklyTextView.setText(intent.getStringExtra("WeeklyNRG"));
        energyMonthlyTextView.setText(intent.getStringExtra("MonthlyNRG"));
    }
}
