package cs134.miracosta.edu.energyhouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import cs134.miracosta.edu.energyhouse.model.DBHelper;
import cs134.miracosta.edu.energyhouse.model.RecycleLocation;

public class WhereToRecycleActivity extends AppCompatActivity implements OnMapReadyCallback {

    private DBHelper db;
    private List<RecycleLocation> allRecyclingLocationsList;

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_recycle);

        deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);
        db.importRecyclingLocationsFromCSV("RecyclingLocations.csv");

        allRecyclingLocationsList = db.getAllRecyclingLocations();

        //Load the support map fragment asynchronously
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().
                findFragmentById(R.id.mapRecyclingFragment);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        map = googleMap;
        //specify our location with LatLng class
        LatLng myPosition = new LatLng(33.190802, -117.301805);

        //add our position to the map
        map.addMarker(new MarkerOptions()
                .position(myPosition)
                .title("Current Location")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.my_marker_recycling)));

        //move the camera to our position
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(myPosition)
                .zoom(15.0f)
                .build();

        //update the position (move to the location)
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);

        //instruct the map to move to this position
        map.moveCamera(cameraUpdate);

        //add all the recycling locations to the map
        //loop through the list and add each location
        LatLng position;

        for(RecycleLocation location : allRecyclingLocationsList)
        {
            position = new LatLng(location.getLatitude(), location.getLongitude());

            map.addMarker(new MarkerOptions()
                    .position(position)
                    .title(location.getInfo()));
        }
    }
}
