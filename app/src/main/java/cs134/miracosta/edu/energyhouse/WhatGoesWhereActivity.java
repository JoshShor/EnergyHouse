package cs134.miracosta.edu.energyhouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import cs134.miracosta.edu.energyhouse.model.RecyclingTypes;
import cs134.miracosta.edu.energyhouse.model.RecyclingTypesJSONLoader;

/**
 * WhatGoesWhereActivity.java - Activity that informs the user of how to recycle certain objects
 *
 * @author Dennis La
 * @version 1.0
 */
public class WhatGoesWhereActivity extends AppCompatActivity {

    private TextView itemTypeTextView;
    private TextView itemDescTextView;

    private ListView recyclingTypesListView;

    private List<RecyclingTypes> allRecyclingTypes;

    private ImageView recyclingBinImageView;
    private Animation fadeInAnimation;

    /**
     * Creates the activity and loads info from JSON file
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_goes_where);

        recyclingBinImageView = findViewById(R.id.recyclingBinImageView);

        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim);

        recyclingBinImageView.startAnimation(fadeInAnimation);

        try {
            allRecyclingTypes = RecyclingTypesJSONLoader.loadJSONFromAsset(this);
        } catch (IOException e) {
            Log.e("Energy House", "Error loading JSON" + e.getMessage());
        }

        itemTypeTextView = findViewById(R.id.itemTypeTextView);
        itemDescTextView = findViewById(R.id.itemDescTextView);

        recyclingTypesListView = findViewById(R.id.recyclingTypesListView);

        RecyclingTypesListAdapter recyclingTypesListAdapter =
                new RecyclingTypesListAdapter(this, R.layout.recycling_types_list_item, allRecyclingTypes);

        recyclingTypesListView.setAdapter(recyclingTypesListAdapter);
    }

    /**
     * Shows user information about how to dispose the chosen item
     *
     * @param v list item view
     */
    public void showInfo(View v)
    {
        RecyclingTypes selectedRecyclingType = (RecyclingTypes) v.getTag();

        itemTypeTextView.setText(selectedRecyclingType.getRecyclableName());
        itemDescTextView.setText(selectedRecyclingType.getHowToDispose());
    }


}
