package com.example.sellFood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.R;

import java.io.FileOutputStream;

public class Confirm extends AppCompatActivity {

    private Sale sample = new Sale();

    private String name, description, choices, unit;
    private Integer size,quantity;
    private Double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmlisting);

        Button backButton = findViewById(R.id.b_backToScreen);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent confirmListing = getIntent();

        TextView tVname = findViewById(R.id.textName);
        TextView tVdesc = findViewById(R.id.textDescription);
        TextView tVdiet = findViewById(R.id.textDietary);
        TextView tVsize = findViewById(R.id.textSize);
        TextView tVquant = findViewById(R.id.textQuantity);
        TextView tVprice = findViewById(R.id.textPrice);

        name = confirmListing.getStringExtra("name");
        description = confirmListing.getStringExtra("description");
        choices = confirmListing.getStringExtra("choices");
        unit = confirmListing.getStringExtra("unit");
        size = confirmListing.getIntExtra("servingSize",0);
        quantity = confirmListing.getIntExtra("quantity", 0);
        price = confirmListing.getDoubleExtra("price",0.0);


        tVname.setText(name);
        tVdesc.setText(description);
        tVdiet.setText(choices);
        tVsize.setText(size.toString() + " " + unit);
        tVquant.setText(quantity.toString());
        tVprice.setText("$" + price);


    }

    protected void confirmListing(View view){
        String filename = "data.txt";

        String listing = name + "\n" + description + "\n" + choices + "\n"+ size.toString() + " " + unit + "\n" + quantity.toString() + "\n" + price.toString() + "\n";

        FileOutputStream outputStream;  //Allow a file to be opened for writing

        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(listing.getBytes());    //FileOutputStream is meant for writing streams of raw bytes.
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent listingScreen = new Intent(this, Listings.class);
        startActivity(listingScreen);
    }

}
