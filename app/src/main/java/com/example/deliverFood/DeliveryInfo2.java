package com.example.deliverFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.R;
import com.example.Tracking2;

public class DeliveryInfo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_info2);

        final Intent intentTrack = new Intent(this, Tracking2.class);
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentTrack.putExtra("trackingID",2);
                startActivity(intentTrack);
            }
        });

        Button back2 = findViewById(R.id.backbutton2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
