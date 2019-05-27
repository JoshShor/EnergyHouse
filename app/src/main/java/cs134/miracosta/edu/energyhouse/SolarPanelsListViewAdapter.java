package cs134.miracosta.edu.energyhouse;

        import android.app.Activity;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import java.text.NumberFormat;
        import java.util.List;
        import java.util.Locale;

        import cs134.miracosta.edu.energyhouse.model.SolarPanels;

/**
 * SolarPanelsListViewAdapter.java handles all views from "solar_panel_list_item.xml"
 *  it then allows for the list items to be displayed ListView "solarPanelsListView"
 *  which is in the SolarActivity Activity
 *
 *
 * @author Joshua Shor
 * @version 1.0
 */
public class SolarPanelsListViewAdapter extends ArrayAdapter<SolarPanels> {

    private Context mContext;
    private int mResourceId;
    private List<SolarPanels> mSolarPanels;

    //number formats for some of the TextViews
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    /**
     * Creates a new <code>SolarPanelsListViewAdapter</code> given a mContext, resource id and list of entries.
     * @param c
     * @param rId
     * @param panels
     */
    public SolarPanelsListViewAdapter(Context c, int rId, List<SolarPanels> panels) {
        super(c, rId, panels);
        mContext = c;
        mResourceId = rId;
        mSolarPanels = panels;
    }

    /**
     * gets the view associated with the layout file "solar_panel_list_item.xml"
     * @param pos
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        SolarPanels focusedSolarPanels = mSolarPanels.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        //tell the inflater to inflate music_event_list_item
        View view = inflater.inflate(mResourceId, null);

        LinearLayout solarPanelsListLinearLayout = view.findViewById(R.id.solarPanelListItem);

        //making custom String variables so the TextViews in the lists will be happy

        String panelCostString = (currency.format(focusedSolarPanels.getCosts()) + "/panel");
        String panelWattsString = (focusedSolarPanels.getWatts() + " Watts/panel");
        String panelAreaString = ("Panel Area: " + focusedSolarPanels.getSqft() + "ft²");

        //fill the parts of the custom view
        TextView panelModelTextView = view.findViewById(R.id.panelModelTextView);
        TextView panelPriceTextView = view.findViewById(R.id.panelPriceTextView);
        TextView panelWattTextView = view.findViewById(R.id.panelWattTextView);
        TextView panelAreaTextView = view.findViewById(R.id.panelAreaTextView);

        panelModelTextView.setText(focusedSolarPanels.getPanel());
        panelPriceTextView.setText(panelCostString);
        panelWattTextView.setText(panelWattsString);
        panelAreaTextView.setText(panelAreaString);

        solarPanelsListLinearLayout.setTag(focusedSolarPanels);

        return view;
    }
}
