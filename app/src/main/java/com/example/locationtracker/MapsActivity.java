package com.example.locationtracker;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.locationtracker.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String coordinates = getIntent().getStringExtra("coordinates");

        Double lat = Double.parseDouble(coordinates.substring(0, coordinates.indexOf(", ")));
        Double lng = Double.parseDouble(coordinates.substring(coordinates.indexOf(", ")+2));

        // Add a marker in Sydney and move the camera
        LatLng loc = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(loc).title("Tracked location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }
}