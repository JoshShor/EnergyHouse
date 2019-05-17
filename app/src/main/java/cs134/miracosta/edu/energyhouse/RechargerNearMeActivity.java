package cs134.miracosta.edu.energyhouse;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RechargerNearMeActivity extends AppCompatActivity {

    private FusedLocationProviderClient fusedLocationClient;
    private int permReqCode = 100;
    private int hasGPSPermissionFine, hasGPSPermissionCourse;
    private double longitude;
    private double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharger_near_me_activty);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        hasGPSPermissionFine = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        hasGPSPermissionCourse = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        if(hasGPSPermissionFine == PackageManager.PERMISSION_DENIED || hasGPSPermissionCourse == PackageManager.PERMISSION_DENIED){
            Toast.makeText(this, R.string.need_gpsPerms, Toast.LENGTH_SHORT).show();
        }else{
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    });
        }



        //use Retrofit library to get openchargeMap json data from api
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openchargemap.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    }
}
