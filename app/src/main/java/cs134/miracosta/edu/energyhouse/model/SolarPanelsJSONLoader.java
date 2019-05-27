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
 * SolarPanelsJSONLoader.java - Class that load the JSON Data from Solar.JSON
 */
public class SolarPanelsJSONLoader {

    /**
     * Loads JSON data from the Solar.JSON file in the assets directory.
     * @param context
     * @return
     * @throws IOException
     */
    public static List<SolarPanels> loadJSONFromAsset(Context context) throws IOException{

        List<SolarPanels> allSolarPanels = new ArrayList<>();
        String json = null;
        InputStream is = context.getAssets().open("SolarPanels.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        json = new String(buffer, "UTF-8");

        try {
            JSONObject jsonRootObject = new JSONObject(json);
            JSONArray allSolarPanelsJSON = jsonRootObject.getJSONArray("SolarPanels");
            int numberOfSolarPanels = allSolarPanelsJSON.length();

            for(int i = 0; i < numberOfSolarPanels; i++){
                JSONObject solarPanelsJSON = allSolarPanelsJSON.getJSONObject(i);

                SolarPanels solarPanels = new SolarPanels();

                solarPanels.setPanel(solarPanelsJSON.getString("Panel"));
                solarPanels.setCosts(solarPanelsJSON.getDouble("Cost"));
                solarPanels.setWatts(solarPanelsJSON.getDouble("WattsPerPanel"));
                solarPanels.setSqft(solarPanelsJSON.getDouble("SquareFeet"));

                allSolarPanels.add(solarPanels);

            }

        } catch (JSONException e) {
            Log.e("Energy House", e.getMessage());
        }


        return allSolarPanels;
    }
}
