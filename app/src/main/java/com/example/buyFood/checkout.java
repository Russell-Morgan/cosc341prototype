package com.example.buyFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.R;

public class checkout extends AppCompatActivity {
    cart thisCart;
    Bundle b;
    Button b1, b2 , b3;
    Intent intent1, intent2, intent3;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.R.layout.activity_checkout);

        Intent intent = getIntent();
        if(intent.hasExtra("b")){
        b = intent.getBundleExtra("b");

        thisCart = (cart) b.getSerializable("thisCart");
        Log.d("Pass","nice");
        }
        else{
            b = intent.getBundleExtra("Bundel");
            thisCart = (cart) b.getSerializable("thisCart");
            address = b.getString("newAdd");

            TextView tVAddress = findViewById(R.id.tVAddress);
            tVAddress.setText(address);
        }

        Button backButton = findViewById(R.id.b_gobacktobuy);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        intent2 = new Intent(this, newaddress.class);
        b2 = (Button) findViewById(R.id.b_newaddressinput);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putSerializable("thisCart", thisCart);
                intent2.putExtra("b",b);
                startActivity(intent2);
            }
        });

        intent3 = new Intent(this, comfirmation.class);
        b3 = (Button) findViewById(R.id.b_buy2);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });

        int ind = 2;

        for(int i = 0; i < thisCart.cartL.size(); i++) {
            TextView tVName = new TextView(this);
            TextView tVPrice = new TextView(this);
            TextView tVQuantity = new TextView(this);
            TextView tVSubtotal= new TextView(this);

            tVName.setText(thisCart.cartL.get(i).getName());
            tVPrice.setText(thisCart.cartL.get(i).getPrice().toString());
            tVQuantity.setText(thisCart.cartL.get(i).getQuantity().toString());

            Log.d("Pass", "quant: " + thisCart.cartL.get(i).getQuantity());
            tVSubtotal.setText(thisCart.cartL.get(i).getSubtotal().toString());

            TableRow newTblRow = new TableRow(this);

            newTblRow.addView(tVName);
            newTblRow.addView(tVPrice);
            newTblRow.addView(tVQuantity);
            newTblRow.addView(tVSubtotal);

            TableLayout orderTable = findViewById(R.id.orderTable);
            orderTable.addView(newTblRow, ind);
            ind++;
        }

        TextView tVTotal = findViewById(R.id.tVTotal);
        tVTotal.setText(thisCart.countTotal().toString());
    }
}
