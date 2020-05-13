package com.example.cabbyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectOptionAuth extends AppCompatActivity {

    Button mButtonIrALogin;
    Button mButtonIrARegistro;

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option_auth);

        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Selecciona opción");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mButtonIrALogin=findViewById(R.id.btnIrALogin);
        mButtonIrALogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });

        mButtonIrARegistro=findViewById(R.id.btnIrARegistro);
        mButtonIrARegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });
    }

    public void goToLogin() {
        Intent intent=new Intent(SelectOptionAuth.this,Login.class);
        startActivity(intent);
    }

    public void goToRegister() {
        Intent intent=new Intent(SelectOptionAuth.this,Registro.class);
        startActivity(intent);
    }
}
