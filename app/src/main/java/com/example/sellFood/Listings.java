package com.example.sellFood;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Listings extends AppCompatActivity {

    Sale classSale = new Sale();
    ArrayList<Sale> dataListings= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);

        Button backButton = findViewById(R.id.b_backToScreen);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayout LL = findViewById(R.id.linearLay);

    //get all info
        String file = "data.txt";
        String line = "";

        try {
            FileInputStream fis = openFileInput(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String yas = "";
            while ((line = br.readLine()) != null){
                yas += line + "\n";
            }

            Log.d("Pass","file read \n"+yas);

            Scanner scan = new Scanner(yas);

            Log.d("Pass","Scanner declared \n");

            while(scan.hasNextLine()){
                String pr = "";
                for(int j = 0; j < 6; j++){
                    pr += scan.nextLine() + "\n";
                }
                Log.d("Pass",pr);
                Sale newSale = classSale.fromString(pr);
                dataListings.add(newSale);
            }


            Log.d("Pass","arrayList Built");

        }catch (FileNotFoundException e){
            e.printStackTrace();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,10,0,10);


        for (int i = 0 ; i < dataListings.size() ; i++){
            final Sale lisT = dataListings.get(i);
            TextView tV = new TextView(this);
            tV.setLayoutParams(params);
            tV.setText(lisT.toString());
            tV.setBackgroundColor(Color.parseColor("#d9d9d9"));
            LL.addView(tV, i);

            tV.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Listings.this, Listing.class);
                    intent.putExtra("sale", lisT.fromSale(lisT));
                    startActivity(intent);
                }
            });
            Log.d("Pass", "in List");
        }

        Log.d("Pass","list built");
//
//        for (int i = 0 ; i < dataListings.size() ; i++){
//            Integer id = LL.getChildAt(i).getId();
//            TextView tV = findViewById(id);
//            final Sale lisT = dataListings.get(i);
//            tV.setText(lisT.toString());
//
//           tV.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    Intent intent = new Intent(Listings.this, Listing.class);
//                    intent.putExtra("sale", lisT.fromSale(lisT));
//                    startActivity(intent);
//                }
//            });
//            Log.d("Pass", "in List");
//        }
//
//        Log.d("Pass","list built");

//        for (Integer i = 0; i<13; i++){
//            Integer id = LL.getChildAt(i).getId();
//            TextView tV = findViewById(id);
//            Integer size = dataListings.size();
//            tV.setText(size.toString());
//        }

//        TextView tt = findViewById(R.id.item1);
//        Integer cool = LL.getChildAt(0).getId();
//        tt.setText(cool.toString() + "\n" + tt.getId());

        // on click

    }

    void addNew(View view){
        Intent intent = new Intent(this, Selling.class);
        startActivity(intent);
    }
}