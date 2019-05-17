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

import cs134.miracosta.edu.energyhouse.model.FuelMileage;

public class FuelMileageListAdapter extends ArrayAdapter<FuelMileage> {

    private Context mContext;
    private List<FuelMileage> mFuelMileagesList;
    private int mResourceId;



    /**
     * Creates a new <code>FuelMileageListAdapter</code> given a mContext, resource id and list of entries.
     *
     * @param c The mContext for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param entries The list of entries to display
     */
    public FuelMileageListAdapter(Context c, int rId, List<FuelMileage> entries) {
        super(c, rId, entries);
        mContext = c;
        mResourceId = rId;
        mFuelMileagesList = entries;
    }

    /**
     * Gets the view associated with the layout.
     * @param pos The position of the FuelMileage selected in the list.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        FuelMileage selectedFuelMileage = mFuelMileagesList.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        LinearLayout offeringListLinearLayout =
                view.findViewById(R.id.fuelMilelageListItem);

        TextView fuelMileageListItemDateTextView =
                view.findViewById(R.id.dateTextView);
        TextView fuelMileageListItemOdometerTextView =
                view.findViewById(R.id.odometerReadingTextView);
        TextView fuelMileageListItemGallonsTextView =
                view.findViewById(R.id.amtFuelTextView);
        TextView fuelMileageListItemTotalCostTextView =
                view.findViewById(R.id.totalFuelCostTextView);

        // TODO (2): Set the text of each of the 3 views accordingly.
        fuelMileageListItemDateTextView.setText(selectedFuelMileage.getDateStr());
        fuelMileageListItemOdometerTextView.setText(String.valueOf(selectedFuelMileage.getOdometerReading()));
        fuelMileageListItemGallonsTextView.setText(String.valueOf(selectedFuelMileage.getFuelAmt()));
        fuelMileageListItemTotalCostTextView.setText(String.valueOf(selectedFuelMileage.getTotalCostFillUp()));

        // Sets the tag, so when user clicks a specific offering, we can respond to that object specifically.
        offeringListLinearLayout.setTag(selectedFuelMileage);
        return view;
    }
}
