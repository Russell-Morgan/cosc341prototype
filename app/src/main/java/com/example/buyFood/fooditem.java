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

    cart thisCart;
    buyListings bL = new buyListings();

    Button buy;
    Spinner quan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooditem);

        final Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("b");
        thisCart = (cart) bundle.getSerializable("thisCart");

        Button backButton = findViewById(R.id.b_gobacktobuy);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView tVname = findViewById(R.id.tVName);
        TextView tVdesc = findViewById(R.id.tVDescription);
        TextView tVVeg = findViewById(R.id.tVChoices);

        Log.d("Pass", "tv got");

        final int id = bundle.getInt("id",0);

        final Intent intentProfile = new Intent(this, com.example.Profile.class);
        final ImageButton profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentProfile);
            }
        });

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

        final Intent toCheckout = new Intent(this, checkout.class);

        buy = (Button) findViewById(R.id.b_buy);
        buy.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {

                                       Integer quantity = Integer.parseInt(quan.getSelectedItem().toString());

                                       thisCart.add(it,quantity);

                                        Log.d("Pass", "quant: " + quantity);

                                        Bundle b = new Bundle();
                                        b.putSerializable("thisCart", thisCart);
                                        toCheckout.putExtra("b",b);

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
