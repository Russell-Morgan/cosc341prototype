package com.example.buyFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.R;

public class comfirmation_cond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfirmation_cond);
        Button b1 = findViewById(R.id.button10);

        final Intent intent1 = new Intent(this, com.example.Tracking2.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent1.putExtra("trackingID", 0);
                startActivity(intent1);
            }
        });
    }
}
