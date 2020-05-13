package com.example.cabbyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButtonSoyConductor;
    Button mButtonSoyPasajero;

    SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPref=getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);
        final SharedPreferences.Editor editor= mPref.edit();


        mButtonSoyConductor=findViewById(R.id.btnSoyConductor);
        mButtonSoyPasajero=findViewById(R.id.btnSoyPasajero);

       mButtonSoyConductor.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               editor.putString("user","conductor");
               editor.apply();
               goToSelectAuth();
           }
       });

        mButtonSoyPasajero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("user","pasajero");
                editor.apply();
                goToSelectAuth();
            }
        });



    }

    private void goToSelectAuth() {
        Intent intent= new Intent(MainActivity.this, SelectOptionAuth.class);
        startActivity(intent);
    }


}
