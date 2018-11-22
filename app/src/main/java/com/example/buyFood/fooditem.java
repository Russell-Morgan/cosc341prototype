package com.example.buyFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.R;

public class fooditem extends AppCompatActivity {

    cart cart, thisCart;
    buyListings bL = new buyListings();

    Button b, buy;
    ImageButton ib;
    Spinner quan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cart = new cart();
        thisCart = new cart();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooditem);

        final Intent intent = getIntent();

        TextView tVname = findViewById(R.id.tVName);
        TextView tVdesc = findViewById(R.id.tVDescription);
        TextView tVVeg = findViewById(R.id.tVChoices);

        Log.d("Pass", "tv got");

        final int id = intent.getIntExtra("id",0);


        Log.d("Pass", "intent get");
        final buyListings.item it = bL.getById(id);

        tVname.setText(it.getName());
        tVdesc.setText(it.getDescription());


        Log.d("Pass", "tv set");
        switch(id){
            case 0:
            tVVeg.setText("Non Vegetarian \nNon Vegan \nMay Contain Dairy \nMay Contain Gluten");
            break;

            case 1:
                tVVeg.setText("");
            break;
        }

        Log.d("Pass", "choices set");

        quan = findViewById(R.id.sp_quan);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.quantities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quan.setAdapter(adapter);

        final Integer quantity = Integer.parseInt(quan.getSelectedItem().toString());

        final Intent toCheckout = new Intent(this, checkout.class);
        buy = (Button) findViewById(R.id.b_buy);
        buy.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                        thisCart.add(it,quantity);
                                        toCheckout.putExtra("thisCart", thisCart);
                                       startActivity(toCheckout);
                                   }
                               });

//        intent1 = new Intent(this, buyfoodlist.class);
//        b = (Button) findViewById(R.id.b_gobacktobuy);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intent1);
//            }
//        });
//
//        intent2 = new Intent(this, checkout.class);
//        buy = (Button) findViewById(R.id.b_buy);
//        buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intent2);
//            }
//        });
    }
}
