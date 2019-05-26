package cs134.miracosta.edu.energyhouse;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.List;
/**
 * Helper class to provide custom adapter for the <code>Appliance</code> list.
 */
import cs134.miracosta.edu.energyhouse.model.ApplianceList;

public class ApplianceListAdapter extends ArrayAdapter<ApplianceList> {

    private Context mContext;
    private List<ApplianceList> mApplianceList;
    private int mResourceId;

    /**
     * Creates a new <code>OfferingListAdapter</code> given a mContext, resource id and list of offerings.
     *
     * @param c The mContext for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param appliances The list of appliances to display
     */
    public ApplianceListAdapter(Context c, int rId, List<ApplianceList> appliances) {
        super(c, rId, appliances);
        mContext = c;
        mResourceId = rId;
        mApplianceList = appliances;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ApplianceList selectedAppliance = mApplianceList.get(pos);

        final ApplianceList focusedApplianceList = mApplianceList.get(pos);


        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId,null);

        LinearLayout applianceListLinearLayout =
                view.findViewById(R.id.usageListItem);
/*
        TextView applianceNameTextView = view.findViewById(R.id.applianceNameTextView);
        TextView applianceWattTextView = view.findViewById(R.id.applianceWattTextView);
        TextView appliancePriceTextView = view.findViewById(R.id.appliancePriceTextView);

        String thePrice = Double.toString(focusedApplianceList.getPrice());

        applianceListLinearLayout.setTag(focusedApplianceList);
        applianceNameTextView.setText(focusedApplianceList.getName());
        applianceWattTextView.setText(Double.toString(focusedApplianceList.getWattUsed()));
        appliancePriceTextView.setText(Double.toString(focusedApplianceList.getPrice()));

*/
        return view;
       // return super.getView(pos, convertView, parent);
    }
}
