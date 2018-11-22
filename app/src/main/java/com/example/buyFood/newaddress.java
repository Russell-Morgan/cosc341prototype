package com.example.buyFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.R;

public class newaddress extends AppCompatActivity {

    Button b;
    Intent intent1;
    String newAdd;
    cart thisCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaddress);

        Intent prevIntent = getIntent();
        Bundle dud = prevIntent.getBundleExtra("b");
        thisCart = (cart) dud.getSerializable("thisCart");

        newAdd = "";

        intent1 = new Intent(this, checkout.class);
        b = (Button) findViewById(R.id.b_sendtothisaddress);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConstraintLayout CL = findViewById(R.id.constLay);
                for (int i = 0; i < CL.getChildCount() - 1; i++) {
                    TextView tv = (TextView) CL.getChildAt(i);
                    if(i==CL.getChildCount()-2)
                    newAdd  += tv.getText().toString();
                    else
                    newAdd += tv.getText().toString() + ", ";
                }


                Bundle bundel = new Bundle();
                bundel.putString("newAdd", newAdd);
                bundel.putSerializable("thisCart", thisCart);

                intent1.putExtra("Bundel", bundel);

                startActivity(intent1);

            }
        });
    }
}
