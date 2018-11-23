package com.example;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tracking2 extends AppCompatActivity {

    Integer iO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        LinearLayout LL = findViewById(R.id.layoutL);
        TextView nameFood = findViewById(R.id.textViewName);
        final Intent finishIntent = new Intent(this, com.example.buyFood.buyfoodlist.class);

        Intent intent = getIntent();

        Button backB = findViewById(R.id.buttonBack);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// change to main menu screen
                startActivity(finishIntent);
            }
        });

        //to change
        nameFood.setText("Chicken n Rice");

        for (int i = 0; i < LL.getChildCount(); i++) {
            Integer id = LL.getChildAt(i).getId();
            TextView tV = findViewById(id);
            tV.setBackgroundColor(Color.parseColor("#006969"));
        }

        int target = intent.getIntExtra("trackingID",0); // 0 =  buying , 1 = selling, 2 = delivery

        // DEMO for Buying
        switch (target) {
            case 0:
                buying(LL);
                break;

            case 1:
                iO = LL.getChildCount()-1;
                selling(LL, iO);
                break;

            case 2:
                iO = LL.getChildCount()-1;
                delivering(LL);
                break;
        }


    }

    protected void buying(final LinearLayout LL) {
        for (int i = LL.getChildCount() - 1; i > 1; i--) {
            Integer id = LL.getChildAt(i).getId();
            TextView tV = findViewById(id);
            tV.setBackgroundColor(Color.parseColor("#420420"));
            tV.setTextColor(Color.parseColor("#FFFFFF"));
        }
        Integer id = LL.getChildAt(1).getId();
        final TextView tVDeliver = findViewById(id);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);


        tVDeliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(false);
                builder.setTitle("Enroute");
                builder.setMessage("Has the order been delivered?");
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                                tVDeliver.setBackgroundColor(Color.parseColor("#420420"));
                                tVDeliver.setTextColor(Color.parseColor("#FFFFFF"));
                                tVDeliver.setClickable(false);

                                Integer id = LL.getChildAt(0).getId();
                                TextView tV = findViewById(id);
                                tV.setBackgroundColor(Color.parseColor("#420420"));
                                tV.setTextColor(Color.parseColor("#FFFFFF"));
                            }
                        });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }


                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    protected void selling(final LinearLayout LL, int xO) {
        if(iO < 0){
            return;
        }else if(iO == 0){
            Integer id = LL.getChildAt(iO).getId();
            final TextView tV = findViewById(id);

            tV.setBackgroundColor(Color.parseColor("#420420"));
            tV.setTextColor(Color.parseColor("#FFFFFF"));
            tV.setClickable(false);
            return;
        } else {
            Integer id = LL.getChildAt(xO).getId();
            final TextView tV = findViewById(id);

            final AlertDialog.Builder builder = new AlertDialog.Builder(this);

            Log.d("Pass", "buld alert");

            tV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    builder.setCancelable(false);
                    builder.setTitle(tV.getText().toString());
                    builder.setMessage(tV.getHint().toString());
                    builder.setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();

                                    tV.setBackgroundColor(Color.parseColor("#420420"));
                                    tV.setTextColor(Color.parseColor("#FFFFFF"));
                                    tV.setClickable(false);
                                    iO -= 1;
                                    selling(LL, iO);
                                }
                            });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Log.d("Pass", "fuk this");
                        }


                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            });


        }

    }

    protected void delivering(final LinearLayout LL) {
        if(iO == 0){
            Integer id = LL.getChildAt(iO).getId();
            final TextView tV = findViewById(id);

            tV.setBackgroundColor(Color.parseColor("#420420"));
            tV.setTextColor(Color.parseColor("#FFFFFF"));
            tV.setClickable(false);
            return;
        }else if(iO == LL.getChildCount()-1){
            Integer id = LL.getChildAt(iO).getId();
            final TextView tV = findViewById(id);

            tV.setBackgroundColor(Color.parseColor("#420420"));
            tV.setTextColor(Color.parseColor("#FFFFFF"));
            tV.setClickable(false);
            iO--;
            delivering(LL);
        } else {
            Integer id = LL.getChildAt(iO).getId();
            final TextView tV = findViewById(id);

            final AlertDialog.Builder builder = new AlertDialog.Builder(this);

            Log.d("Pass", "buld alert");

            tV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    builder.setCancelable(false);
                    builder.setTitle(tV.getText().toString());
                    builder.setMessage(tV.getHint().toString());
                    builder.setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();

                                    tV.setBackgroundColor(Color.parseColor("#420420"));
                                    tV.setTextColor(Color.parseColor("#FFFFFF"));
                                    tV.setClickable(false);
                                    iO -= 1;
                                    selling(LL, iO);
                                }
                            });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Log.d("Pass", "fuk this");
                        }


                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            });


        }

    }
}
