package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner cbintents;
    private Button btnstart;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnstart = findViewById(R.id.btnstart);
        btnstart.setOnClickListener(this);

        cbintents = (Spinner)findViewById(R.id.cbintents);
        String[] intents = {"Intentos","5","7","10"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,intents);
        cbintents.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnstart){
            String selection = cbintents.getSelectedItem().toString();
            if (selection.equals("Intentos")){
                Toast.makeText(getApplicationContext(), "Seleccione el número de intentos", Toast.LENGTH_LONG).show();
            }
            else{
                Intent i = new Intent(getApplicationContext(), GameActivity.class);
                int intents = Integer.parseInt(selection);
                i.putExtra("intents",intents);
                startActivity(i);
            }
        }
    }
}