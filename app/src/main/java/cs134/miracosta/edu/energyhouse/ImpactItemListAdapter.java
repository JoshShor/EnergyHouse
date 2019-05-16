package cs134.miracosta.edu.energyhouse;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cs134.miracosta.edu.energyhouse.model.ImpactItem;


public class ImpactItemListAdapter extends ArrayAdapter<ImpactItem>
{
    private Context mContext;
    private List<ImpactItem> mImpactItemsList = new ArrayList<>();
    private int mResourceId;

    public ImpactItemListAdapter(Context c, int rId, List<ImpactItem> impactItems) {
        super(c, rId, impactItems);
        mContext = c;
        mResourceId = rId;
        mImpactItemsList = impactItems;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final ImpactItem focusedImpactItem = mImpactItemsList.get(pos);

        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        ConstraintLayout impactItemListItem = view.findViewById(R.id.impactItemListItem);

        TextView impactItemTextView = view.findViewById(R.id.impactItemTextView);
        TextView poundsPaperTextView = view.findViewById(R.id.poundsPaperTextView);
        TextView poundsMixedTextView = view.findViewById(R.id.poundsMixedTextView);

        impactItemListItem.setTag(focusedImpactItem);

        String s = mContext.getString(R.string.entry_num) + " " + (pos + 1);
        impactItemTextView.setText(s);

        s = mContext.getString(R.string.pounds_paper) + " " + focusedImpactItem.getPoundsOfPaper();
        poundsPaperTextView.setText(s);

        s = mContext.getString(R.string.pounds_mixed) + " " + focusedImpactItem.getPoundsOfMixedRecyclables();
        poundsMixedTextView.setText(s);

        return view;
    }
}
