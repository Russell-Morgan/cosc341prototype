package com.example.yhy92.cosc341proj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class comfirmation extends AppCompatActivity {

    Button b1;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirmation);

        intent1 = new Intent(this, comfirmation_cond.class);
        b1 = (Button) findViewById(R.id.b_placeorder);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }
}
