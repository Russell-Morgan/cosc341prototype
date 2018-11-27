package com.example;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class registration extends AppCompatActivity {

    //global variables
    String nam = "";
    String ema ="";
    String confem = "";
    String pass = "";
    String confpass = "";
    String phonenum = "";
    String credit = "";
    String expire = "";
    String security = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button reg = (Button) findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //ALL THE TO STRINGS AND ALL THE NAMES
                EditText namnam = findViewById(R.id.name);
                nam = namnam.getText().toString();

                EditText emaema = findViewById(R.id.email);
                ema = emaema.getText().toString();

                EditText confemem = findViewById(R.id.confemail);
                confem = confemem.getText().toString();

                EditText passpass = findViewById(R.id.password);
                pass = passpass.getText().toString();

                EditText confpasspass = findViewById(R.id.confpassword);
                confpass = confpasspass.getText().toString();

                EditText phonenumnum = findViewById(R.id.phone);
                phonenum = phonenumnum.getText().toString();

                EditText creditit = findViewById(R.id.creditcard);
                credit = creditit.getText().toString();

                EditText expireire = findViewById(R.id.expiry);
                expire = expireire.getText().toString();

                EditText secure = findViewById(R.id.securitycode);
                security = secure.getText().toString();

                if (nam.equals("")){
                    Toast.makeText(getApplicationContext(),"Please input your name.", Toast.LENGTH_SHORT).show();
                }
                else if (ema.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input your email address.", Toast.LENGTH_SHORT).show();
                }
                else if (confem.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill in the confirm email.", Toast.LENGTH_SHORT).show();
                }
                else if (!ema.equals(confem)) {
                    Toast.makeText(getApplicationContext(), "Please use the same email address.", Toast.LENGTH_SHORT).show();

                }
                else if (pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input your desired password.", Toast.LENGTH_SHORT).show();
                }
                else if (confpass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill in the confirm password.", Toast.LENGTH_SHORT).show();
                }
                else if (!confpass.equals(pass)) {
                    Toast.makeText(getApplicationContext(), "Please use the same password.", Toast.LENGTH_SHORT).show();
                }
                else if (phonenum.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input your phone number.", Toast.LENGTH_SHORT).show();
                }
                else if (credit.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input your credit card number.", Toast.LENGTH_SHORT).show();
                }
                else if (expire.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input your credit card expiry date (mmyy).", Toast.LENGTH_SHORT).show();
                }
                else if (security.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input your credit card security number", Toast.LENGTH_SHORT).show();
                }
                else{
                    //make storage file
                    String filename = "regdata.txt";
                    String contents = nam+","+ema+","+pass+","+phonenum+","+credit+","+expire+","+security + "\n";
                    FileOutputStream output;

                    try {
                        output = openFileOutput(filename, Context.MODE_APPEND);
                        output.write(contents.getBytes());
                        output.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    finish();
                }

            }
        });
    }
}
