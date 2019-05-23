package cs134.miracosta.edu.energyhouse.model;

import android.util.Log;

import org.json.JSONArray;

import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class loads Pokemon data from a formatted JSON (JavaScript Object Notation) file.
 * Populates data model (location) with data.
 */



public class JSONLoader {

    private static List<ChargeLocation> allChargeLocations = new ArrayList<>();
    private static ChargeLocation chargeLocation;
    private static long longitude, latitude, distance;
    private static String address, city, state, zip;

    //public static final String IMG_URI_BASE = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/";


    // TODO: Add a static method that reads the pokedex.json file directly from the web
    // TODO: instead of using local AssetManager.  The pokedex can be found here:
    // TODO: https://github.com/Biuni/PokemonGO-Pokedex/blob/master/pokedex.json
    public static List<ChargeLocation> loadJSONFromHTTP(JSONObject json) throws IOException {


        try {
            JSONObject jsonRootObject = json;
            JSONArray allMusicEventsJSON = jsonRootObject.getJSONArray("location");
            int numberOfEvents = allMusicEventsJSON.length();


            for (int i = 0; i < numberOfEvents; i++) {
                JSONObject pmJSON = allMusicEventsJSON.getJSONObject(i);
                address = (pmJSON.has("AddressLine1")) ? pmJSON.getString("AddressLine1") : "None";
                city = (pmJSON.has("Town")) ? pmJSON.getString("Town") : "None";
                state = (pmJSON.has("StateOfProvince")) ? pmJSON.getString("StateOfProvince") : "None";
                zip = (pmJSON.has("Postcode")) ? pmJSON.getString("Postcode") : "None";
                longitude = (pmJSON.has("Longitude")) ? pmJSON.getLong("Longitude") : 0;
                latitude = (pmJSON.has("Latitude")) ? pmJSON.getLong("Latitude") : 0;
                distance = (pmJSON.has("Distance")) ? pmJSON.getLong("Distance") : 0;
                Log.i("JSON Loader-constructor", address);
                chargeLocation = new ChargeLocation(address, city, state, zip, longitude, latitude, distance);
                allChargeLocations.add(chargeLocation);
            }
        } catch (Exception e) {
            Log.e("JSONLoader class", e.getMessage());
        }

        return allChargeLocations;
    }
}