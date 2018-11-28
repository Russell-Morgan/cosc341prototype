package com.example.sellFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.R;

public class Listing extends AppCompatActivity {

    Sale sample = new Sale();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        Button backButton = findViewById(R.id.b_backToScreen);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Intent in = getIntent();

        String str = in.getStringExtra("sale");

        Sale listing = sample.fromString(str);

        TextView tVname = findViewById(R.id.textName);
        TextView tVdesc = findViewById(R.id.textDescription);
        TextView tVdiet = findViewById(R.id.textDietary);
        TextView tVsize = findViewById(R.id.textSize);
        TextView tVquant = findViewById(R.id.textQuantity);
        TextView tVprice = findViewById(R.id.textPrice);

        tVname.setText(listing.getName());
        tVdesc.setText(listing.getDescription());
        tVdiet.setText(listing.getChoices());
        tVsize.setText(listing.getSize().toString() + " " + listing.getUnit());
        tVquant.setText(listing.getQuantity().toString());
        tVprice.setText(listing.getPrice().toString());

    }
}
