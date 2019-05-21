package cs134.miracosta.edu.energyhouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cs134.miracosta.edu.energyhouse.model.DBHelper;
import cs134.miracosta.edu.energyhouse.model.ImpactItem;


public class ImpactActivity extends AppCompatActivity {

    private DBHelper mImpactDBHelper;
    private List<ImpactItem> mImpactItemList;
    private ImpactItemListAdapter mImpactItemListAdapter;

    private static double mNumTrees = 0;
    private static double mNumOil = 0;
    private static double mNumElec = 0;
    private static double mNumWater = 0;

    //view components
    private EditText poundsPaperEditText;
    private EditText poundsMixedEditText;

    private TextView numTreesTextView;
    private TextView galOilTextView;
    private TextView hrsElecTextView;
    private TextView galWaterTextView;

    private ListView impactLogListView;

    private ImageView treeImageView;
    private ImageView oilImageView;
    private ImageView elecImageView;
    private ImageView waterImageView;
    private Animation fadeInAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impact);

        treeImageView = findViewById(R.id.treeImageView);
        oilImageView = findViewById(R.id.oilImageView);
        elecImageView = findViewById(R.id.elecImageView);
        waterImageView = findViewById(R.id.waterImageView);

        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim);

        treeImageView.startAnimation(fadeInAnimation);
        oilImageView.startAnimation(fadeInAnimation);
        elecImageView.startAnimation(fadeInAnimation);
        waterImageView.startAnimation(fadeInAnimation);

        mImpactDBHelper = new DBHelper(this);
        mImpactItemList = mImpactDBHelper.getAllImpactItems();
        mImpactItemListAdapter = new ImpactItemListAdapter(this, R.layout.impact_item_list_item, mImpactItemList);
        impactLogListView = findViewById(R.id.impactLogListView);
        impactLogListView.setAdapter(mImpactItemListAdapter);

        poundsPaperEditText = findViewById(R.id.poundsPaperEditText);
        poundsMixedEditText = findViewById(R.id.poundsMixedEditText);

        numTreesTextView = findViewById(R.id.numTreesTextView);
        galOilTextView = findViewById(R.id.galOilTextView);
        hrsElecTextView = findViewById(R.id.hrsElecTextView);
        galWaterTextView = findViewById(R.id.galWaterTextView);

        initializeTotals();

        setTextViewCounters();

    }

    private void initializeTotals()
    {
        if(!mImpactItemList.isEmpty())
        {
            for(ImpactItem impactItem : mImpactItemList)
            {
                mNumTrees += impactItem.calcNumTreesSaved();
                mNumOil += impactItem.calcNumGallonsOfOilSaved();
                mNumElec += impactItem.calcHoursOfElectricitySaved();
                mNumWater += impactItem.calcNumGallonsOfWaterSaved();
            }
        }
    }

    public void addToLog(View v)
    {
        if(TextUtils.isEmpty(poundsPaperEditText.getText()) || TextUtils.isEmpty(poundsMixedEditText.getText()))
        {
            Toast.makeText(this, getString(R.string.invalid_impact), Toast.LENGTH_SHORT).show();

            return;
        }

        double poundsPaper = Double.parseDouble(poundsPaperEditText.getText().toString());
        double poundsMixed = Double.parseDouble(poundsMixedEditText.getText().toString());

        ImpactItem impactItem = new ImpactItem(poundsPaper, poundsMixed);

        mImpactDBHelper.addImpactItem(impactItem);

        mImpactItemListAdapter.add(impactItem);

        addToTotals(impactItem);
    }

    private void addToTotals(ImpactItem newImpactItem)
    {
        mNumTrees += newImpactItem.calcNumTreesSaved();
        mNumOil += newImpactItem.calcNumGallonsOfOilSaved();
        mNumElec += newImpactItem.calcHoursOfElectricitySaved();
        mNumWater += newImpactItem.calcNumGallonsOfWaterSaved();

        setTextViewCounters();
    }

    public void clearLog(View v)
    {
        mImpactDBHelper.deleteAllImpactItems();

        mImpactItemList.clear();

        mImpactItemListAdapter.notifyDataSetChanged();

        //reset all totals
        mNumTrees = 0;
        mNumOil = 0;
        mNumElec = 0;
        mNumWater = 0;

        setTextViewCounters();

    }

    private void setTextViewCounters()
    {
        numTreesTextView.setText(String.valueOf(Math.round(mNumTrees)));
        galOilTextView.setText(String.valueOf(Math.round(mNumOil)));
        hrsElecTextView.setText(String.valueOf(Math.round(mNumElec)));
        galWaterTextView.setText(String.valueOf(Math.round(mNumWater)));
    }

}
