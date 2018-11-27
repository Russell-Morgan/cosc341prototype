package com.example.buyFood;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.R;

public class buyfoodlist extends AppCompatActivity {


    Intent intent1;
    public cart thisCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyfoodlist);

        Log.d("Pass", "ok");
        thisCart = new cart();

        Log.d("Pass", "ok");

        TextView food1 = findViewById(R.id.textViewChicken);
        TextView food2 = findViewById(R.id.textViewAsparagus);

        food1.setBackgroundColor(Color.parseColor("#d9d9d9"));
        food2.setBackgroundColor(Color.parseColor("#d9d9d9"));

        Log.d("Pass", "ok");
        //sample food for sale
        buyListings.item chickenNRice = new buyListings.item("Chicken And Rice","This chicken and rice meal will be delicious! Just pop this juicy piece of meat in your oven or microwave and enjoy! Fully cooked.", 7.5, 0);
        buyListings.item asparagus = new buyListings.item("Asparagus and Parmesan Cheese", "Vegetables are good for you, so is this asparagus! It tastes like cheese with vegetables.",5.02, 1);

        Log.d("Pass", "items loaded");

        food1.setText(chickenNRice.toString());
        food2.setText(asparagus.toString());

        Log.d("Pass", "text changed");

        intent1 = new Intent(this, fooditem.class);

        Log.d("Pass", "intent set");

        food1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putInt("id",0);
                b.putSerializable("thisCart", thisCart);
                intent1.putExtra("b",b);
                startActivity(intent1);
            }
        });

        Log.d("Pass", "food1 set");

        food2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putInt("id",1);
                b.putSerializable("thisCart", thisCart);
                intent1.putExtra("b",b);
                startActivity(intent1);
            }
        });

        Log.d("Pass", "food2 set");

    }

}
