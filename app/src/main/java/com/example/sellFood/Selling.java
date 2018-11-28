package com.example.sellFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.R;

public class Selling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling);

        Button backButton = findViewById(R.id.b_backToScreen);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Spinner unitSpinner = findViewById(R.id.spinnerUnit);

        ArrayAdapter<CharSequence> unitAdapter =  ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitSpinner.setAdapter(unitAdapter);

        Spinner quantitySpinner = findViewById(R.id.spinnerQuantity);

        ArrayAdapter<CharSequence> quantityAdapter =  ArrayAdapter.createFromResource(this, R.array.quantities, android.R.layout.simple_spinner_item);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        quantitySpinner.setAdapter(quantityAdapter);
    }

    void newListing(View view){
        String name = "", description="", choices="", unit="";
        Integer servingSize=0, quantity=0;
        Double price=0.0;
        Boolean good = true;

        EditText editName = findViewById(R.id.editName);
        if(editName.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter a Name", Toast.LENGTH_LONG).show();
            good=false;
        }
        else
            name = editName.getText().toString();

        Log.d("Pass","name ok");

        EditText editDescription = findViewById(R.id.editDescription);
        if(editDescription.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter a Description", Toast.LENGTH_LONG).show();
            good=false;
        }
        else
            description = editDescription.getText().toString();

        Log.d("Pass","description ok");

        choices = "";
        CheckBox checkBoxVege = findViewById(R.id.checkBoxVege);
        if(checkBoxVege.isChecked())
            choices += "Vegetarian-Safe ";

        CheckBox checkBoxVegan = findViewById(R.id.checkBoxVegan);
        if(checkBoxVegan.isChecked())
            choices += "Vegan-Safe ";

        CheckBox checkBoxGluten = findViewById(R.id.checkBoxGluten);
        if(checkBoxGluten.isChecked())
            choices += "Gluten-Free ";

        CheckBox checkBoxDairy = findViewById(R.id.checkBoxDairy);
        if(checkBoxDairy.isChecked())
            choices += "Dairy-Free";

        EditText editServings = findViewById(R.id.editServings);
        if(editServings.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter a Serving", Toast.LENGTH_LONG).show();
            good=false;
        }
        else {
            servingSize = Integer.parseInt(editServings.getText().toString());

            if (servingSize == 0) {
                Toast.makeText(getApplicationContext(), "Serving size cannot be 0", Toast.LENGTH_LONG).show();
                good = false;
            }
        }

        Log.d("Pass","serving ok");

        Spinner spinnerUnit = findViewById(R.id.spinnerUnit);
        unit = spinnerUnit.getSelectedItem().toString();

        Spinner spinnerQuantity = findViewById(R.id.spinnerQuantity);
        quantity = Integer.parseInt(spinnerQuantity.getSelectedItem().toString());

        EditText editPrice = findViewById(R.id.editPrice);
        if(editPrice.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Enter a Price" +
                    "", Toast.LENGTH_LONG).show();
            good=false;
        }
        else {
            price = Double.parseDouble(editPrice.getText().toString());
            if(price == 0.0){
                Toast.makeText(getApplicationContext(), "Price cannot be 0", Toast.LENGTH_LONG).show();
                good=false;
            }
        }
        Log.d("Pass","price ok");

        if(good==true){
            Intent confirm = new Intent(this, Confirm.class);

            confirm.putExtra("name", name);
            confirm.putExtra("description", description);
            confirm.putExtra("choices", choices);
            confirm.putExtra("servingSize", servingSize);
            confirm.putExtra("unit", unit);
            confirm.putExtra("quantity", quantity);
            confirm.putExtra("price", price);

            startActivity(confirm);
        }
    }
}
