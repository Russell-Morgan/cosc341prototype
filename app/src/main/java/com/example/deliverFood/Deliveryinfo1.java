package com.example.deliverFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.R;
import com.example.Tracking2;

public class Deliveryinfo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliveryinfo1);

        final Intent intentTrack = new Intent(this, Tracking2.class);

        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentTrack.putExtra("trackingID",2);
                startActivity(intentTrack);
            }
        });
        Button back1 = findViewById(R.id.backbutton1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
