package cs134.miracosta.edu.energyhouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import cs134.miracosta.edu.energyhouse.model.RecyclingTypes;
import cs134.miracosta.edu.energyhouse.model.RecyclingTypesJSONLoader;

public class WhatGoesWhereActivity extends AppCompatActivity {

    private TextView itemTypeTextView;
    private TextView itemDescTextView;

    private ListView recyclingTypesListView;

    List<RecyclingTypes> allRecyclingTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_goes_where);

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

    public void showInfo(View v)
    {
        RecyclingTypes selectedRecyclingType = (RecyclingTypes) v.getTag();

        itemTypeTextView.setText(selectedRecyclingType.getRecyclableName());
        itemDescTextView.setText(selectedRecyclingType.getHowToDispose());
    }


}
