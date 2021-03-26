package com.example.adivina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnverify, btnagain;
    private EditText edtnumber;
    private int random;
    private int intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        edtnumber = (EditText)findViewById(R.id.edtnumber);
        btnverify = (Button)findViewById(R.id.btnverify);
        btnverify.setOnClickListener(this);
        btnagain = (Button)findViewById(R.id.btnagain);
        btnagain.setOnClickListener(this);

        Random rnd = new Random();
        random = rnd.nextInt(101);
        intents = getIntent().getIntExtra("intents",5);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnverify){
            if(validate()){
                int valor_edtn = Integer.parseInt(edtnumber.getText().toString());
                if(valor_edtn == random){
                    Toast.makeText(getApplicationContext(), "¡GANASTE! El número era " + random, Toast.LENGTH_LONG).show();
                    btnagain.setVisibility(v.VISIBLE);
                    btnverify.setVisibility(v.INVISIBLE);
                }
                else{
                    intents = intents - 1;
                    if(intents == 0){
                        Toast.makeText(getApplicationContext(), "¡PERDISTE! Te quedaste sin intentos, el número era " + random, Toast.LENGTH_LONG).show();
                        btnagain.setVisibility(v.VISIBLE);
                        btnverify.setVisibility(v.INVISIBLE);
                    }
                    else{
                        if(valor_edtn < random){
                            Toast.makeText(getApplicationContext(), "El número es mayor, te quedan " + intents + " intentos", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "El número es menor, te quedan " + intents + " intentos", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Ingrese un número válido", Toast.LENGTH_LONG).show();
            }
        }
        else if(v.getId() == R.id.btnagain){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }
    }

    public boolean validate(){
        if (TextUtils.isEmpty(edtnumber.getText().toString()) || !TextUtils.isDigitsOnly(edtnumber.getText().toString())){
            return false;
        }
        else{
            if(Integer.parseInt(edtnumber.getText().toString()) < 0 || Integer.parseInt(edtnumber.getText().toString()) > 100){
                return false;
            }
            else{
                return true;
            }
        }
    }
}