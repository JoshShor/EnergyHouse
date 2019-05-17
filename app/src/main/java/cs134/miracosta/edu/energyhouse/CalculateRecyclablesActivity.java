package cs134.miracosta.edu.energyhouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.energyhouse.model.RecyclingCRV;


public class CalculateRecyclablesActivity extends AppCompatActivity {

    private EditText aluminumEditText;
    private EditText petEditText;
    private EditText hdpeEditText;
    private EditText glassEditText;

    private TextView valueTextView;

    private NumberFormat mNumberFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_recyclables);

        aluminumEditText = findViewById(R.id.aluminumEditText);
        petEditText = findViewById(R.id.petEditText);
        hdpeEditText = findViewById(R.id.hdpeEditText);
        glassEditText = findViewById(R.id.glassEditText);

        valueTextView = findViewById(R.id.valueTextView);

        mNumberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
    }

    public void calcValue(View v)
    {
        double aluminum = aluminumEditText.getText().toString().equals("") ?
                0 : Double.parseDouble(aluminumEditText.getText().toString());

        double PET = petEditText.getText().toString().equals("") ?
                0 : Double.parseDouble(petEditText.getText().toString());

        double HDPE = hdpeEditText.getText().toString().equals("") ?
                0 : Double.parseDouble(hdpeEditText.getText().toString());

        double glass = glassEditText.getText().toString().equals("") ?
                0 : Double.parseDouble(glassEditText.getText().toString());

        RecyclingCRV recyclingCRV = new RecyclingCRV(aluminum, PET, HDPE, glass);

        String value = mNumberFormat.format(recyclingCRV.calcCRV());

        valueTextView.setText(value);

    }
}
