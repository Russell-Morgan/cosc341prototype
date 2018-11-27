package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    //declaring global variables
    String use = "";
    String pas = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //pressing the login button
        Button login = (Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent  logon = new Intent(Login.this, main.class);

                //next is checking that the username and password have something as input (did not code any requirements like neeeds caps or special symbol)
                EditText user = findViewById(R.id.usernam);
                use = user.getText().toString();

                EditText pass = findViewById(R.id.passwordd);
                pas = pass.getText().toString();


                if(use.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter a username.", Toast.LENGTH_SHORT).show();
                }
                else if(pas.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter a password.", Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(logon);
                }




            }
        });
        Button register = (Button) findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                Intent regist = new Intent(Login.this, registration.class);
                startActivity(regist);

            }
        });
    }
}
