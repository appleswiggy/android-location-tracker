package com.example.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private void changeActivity(String data) {
        Intent intent = new Intent(this, MapsActivity.class);
        if (!data.equals("")) {
            intent.putExtra("coordinates", data);
        }
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trackButton = findViewById(R.id.trackButton);
        Button shareButton = findViewById(R.id.shareButton);

        trackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextCoordinates = findViewById(R.id.editTextCoordinates);
                String coordinates = editTextCoordinates.getText().toString();

                if (!coordinates.equals("")) {
                    changeActivity(coordinates);
                }
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShareActivity.class);
                startActivity(intent);
            }
        });
    }
}