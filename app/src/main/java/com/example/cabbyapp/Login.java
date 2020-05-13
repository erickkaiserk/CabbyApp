package com.example.cabbyapp;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cabbyapp.Includes.ToolBar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dmax.dialog.SpotsDialog;

public class Login extends AppCompatActivity {

    TextInputEditText mTxtCorreo;
    TextInputEditText mTxtPassword;

    Button mButtonIngresar;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    AlertDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ToolBar.show(this,"Login de usuario", true);

        mTxtCorreo=findViewById(R.id.txtCorreo);
        mTxtPassword=findViewById(R.id.txtPassword);
        mButtonIngresar=findViewById(R.id.btnIngresar);

        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

        mDialog= new SpotsDialog.Builder().setContext(Login.this).setMessage("Espere un momento").build();



        mButtonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        String correo=mTxtCorreo.getText().toString();
        String password=mTxtPassword.getText().toString();

        if(!correo.isEmpty() && !password.isEmpty()){
            if(password.length()>=6){
                mDialog.show();
                mAuth.signInWithEmailAndPassword(correo,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Login realizado exitosamente", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Login.this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                        }
                        mDialog.dismiss();
                    }
                });
            }else{
                Toast.makeText(Login.this, "La contraseña debe tener mas de 6 caractéres", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(Login.this, "El correo y la contraseña son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }
}
