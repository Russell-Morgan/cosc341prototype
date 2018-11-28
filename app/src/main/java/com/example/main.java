package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //just needs the proper intents

        //empty button buy
        Button buy = (Button) findViewById(R.id.buyfood);
        buy.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent  buyer = new Intent(main.this, com.example.buyFood.buyfoodlist.class);
                startActivity(buyer);
            }
        });

        //empty button sell
        Button sell = (Button) findViewById(R.id.sellfood);
        sell.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent seller = new Intent(main.this, com.example.sellFood.Listings.class);
                startActivity(seller);
            }
        });

        //empty button deliver
        Button deliver = (Button) findViewById(R.id.deliverfood);
        deliver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent deliverer = new Intent(main.this, com.example.deliverFood.Delivery_main.class);
                startActivity(deliverer);
            }
        });

        //empty button history
        Button history = (Button) findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){

            }
        });

        //empty button profile
        Button profile = (Button) findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                startActivity(new Intent(main.this, Profile.class));
            }
        });

    }
}
