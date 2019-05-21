package cs134.miracosta.edu.energyhouse.model;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * RecyclingTypesJSONLoader.java - Class that loads the JSON data
 *
 * @author Dennis La
 * @version 1.0
 */
public class RecyclingTypesJSONLoader
{
    /**
     * Loads JSON data from a JSON file
     *
     * @param context
     * @return a list of RecyclingTypes
     * @throws IOException
     */
    public static List<RecyclingTypes> loadJSONFromAsset(Context context) throws IOException
    {
        List<RecyclingTypes> allRecyclingTypes = new ArrayList<>();

        String json;
        InputStream is = context.getAssets().open("RecyclingTypes.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            JSONArray allRecyclingTypesJSON = jsonRootObject.getJSONArray("RecyclingTypes");
            int numberOfRecyclingTypes = allRecyclingTypesJSON.length();

            for (int i = 0; i < numberOfRecyclingTypes; i++)
            {
                JSONObject recyclingTypeJSON = allRecyclingTypesJSON.getJSONObject(i);

                RecyclingTypes recyclingType = new RecyclingTypes();

                recyclingType.setRecyclableName(recyclingTypeJSON.getString("Name"));
                recyclingType.setHowToDispose(recyclingTypeJSON.getString("HowToDispose"));

                allRecyclingTypes.add(recyclingType);
            }
        }
        catch (JSONException e)
        {
            Log.e("Energy House", e.getMessage());
        }

        return allRecyclingTypes;
    }
}
