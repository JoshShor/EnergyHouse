package cs134.miracosta.edu.energyhouse;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cs134.miracosta.edu.energyhouse.model.RecyclingTypes;

/**
 * RecyclingTypesListAdapter.java - Adapter for the list view in WhatGoesWhereActivity
 *
 * @author Dennis La
 * @version 1.0
 */
public class RecyclingTypesListAdapter extends ArrayAdapter<RecyclingTypes>
{
    private Context mContext;
    private int mResourceId;
    private List<RecyclingTypes> mAllRecyclingTypes;

    /**
     * Constructor
     *
     * @param context context
     * @param resource id of list item resource layout
     * @param objects list of items
     */
    public RecyclingTypesListAdapter(Context context, int resource, List<RecyclingTypes> objects) {
        super(context, resource, objects);

        mContext = context;
        mResourceId = resource;
        mAllRecyclingTypes = objects;

    }

    /**
     * Inflates the list item view
     *
     * @param pos position of list item
     * @param convertView
     * @param parent
     * @return the inflated list item view
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final RecyclingTypes focusedRecyclingType = mAllRecyclingTypes.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        ConstraintLayout recyclingTypeListItem = view.findViewById(R.id.recyclingTypeListItem);
        TextView recyclableNameTextView = view.findViewById(R.id.recyclableNameTextView);

        recyclingTypeListItem.setTag(focusedRecyclingType);
        recyclableNameTextView.setText(focusedRecyclingType.getRecyclableName());

        return view;
    }


}
