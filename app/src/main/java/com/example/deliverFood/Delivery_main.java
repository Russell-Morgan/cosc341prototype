package com.example.deliverFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.R;

public class Delivery_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_main);

        Button takeorder1 = (Button) findViewById(R.id.button2);
        takeorder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ord1 = new Intent(Delivery_main.this, Deliveryinfo1.class);
                startActivity(ord1);
            }
        });

        Button takeorder2 = (Button) findViewById(R.id.button3);
        takeorder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ord2 = new Intent(Delivery_main.this, DeliveryInfo2.class);
                startActivity(ord2);
            }
        });

        Button takeorder3 = (Button) findViewById(R.id.button4);
        takeorder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ord3 = new Intent(Delivery_main.this, DeliveryInfo3.class);
                startActivity(ord3);
            }
        });
    }
}
