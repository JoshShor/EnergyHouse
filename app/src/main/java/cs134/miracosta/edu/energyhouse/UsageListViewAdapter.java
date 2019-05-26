package cs134.miracosta.edu.energyhouse;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import cs134.miracosta.edu.energyhouse.model.UsageTracker;

public class UsageListViewAdapter extends ArrayAdapter<UsageTracker> {

    private Context mContext;
    private List<UsageTracker> mUsageTracker;
    private int mResourceID;

    /**
     * Creates a new <code>UsageListViewAdapter</code> given a mContext, resource id and list of entries.
     * @param c
     * @param rId
     * @param entries
     */
    public UsageListViewAdapter(Context c, int rId, List<UsageTracker> entries) {
        super(c, rId, entries);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        UsageTracker focusedUsageTracker = mUsageTracker.get(pos);

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(mResourceID, null);

        LinearLayout offeringListLinearLayout = view.findViewById(R.id.usageListItem);

        String wattString = (Double.toString(focusedUsageTracker.getWattsUsed()) + " Watt-Hours this day");

        TextView dateWattTextView = view.findViewById(R.id.dateWattTextView);
        TextView timeWattTextView = view.findViewById(R.id.timeWattTextView);
        TextView wattThisDayTextView = view.findViewById(R.id.wattThisDayTextView);

        dateWattTextView.setText(focusedUsageTracker.getDayStr());
        timeWattTextView.setText(focusedUsageTracker.getTimeStr());
        wattThisDayTextView.setText(wattString);

        return view;
    }
}
