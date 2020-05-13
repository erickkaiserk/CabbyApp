package com.example.cabbyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cabbyapp.Modelo.Cliente;
import com.example.cabbyapp.Modelo.User;
import com.example.cabbyapp.Includes.ToolBar;
import com.example.cabbyapp.Providers.AuthProvider;
import com.example.cabbyapp.Providers.ClienteProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dmax.dialog.SpotsDialog;

public class Registro extends AppCompatActivity {

    SharedPreferences mPref;

    AuthProvider mAuthProvider;
    ClienteProvider mClienteProvider;
    Button mButtonRegistrar;
    TextInputEditText mTxtNombre;
    TextInputEditText mTxtCorreo;
    TextInputEditText mTxtPassword;

    AlertDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ToolBar.show(this, "Registro de usuario", true);

        mAuthProvider = new AuthProvider();
        mClienteProvider = new ClienteProvider();

        mPref = getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);

        mButtonRegistrar = findViewById(R.id.btnRegistrar);
        mTxtNombre = findViewById(R.id.txtNombre);
        mTxtCorreo = findViewById(R.id.txtCorreo);
        mTxtPassword = findViewById(R.id.txtPassword);

        mDialog = new SpotsDialog.Builder().setContext(Registro.this).setMessage("Espere un momento").build();

        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickRegistrar();
            }
        });
    }

    void clickRegistrar() {
        final String nombre = mTxtNombre.getText().toString();
        final String correo = mTxtCorreo.getText().toString();
        final String password = mTxtPassword.getText().toString();

        if (!nombre.isEmpty() && !correo.isEmpty() && !password.isEmpty()) {
            if (password.length() >= 6) {
                mDialog.show();
                registrar(nombre, correo, password);
            } else {
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    void registrar(final String nombre, final String correo, String password) {
        mAuthProvider.register(correo, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mDialog.hide();
                if (task.isSuccessful()) {
                    String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    Cliente cliente = new Cliente(id, nombre, correo);
                    create(cliente);
                } else {
                    Toast.makeText(Registro.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void create(Cliente cliente) {
        mClienteProvider.create(cliente).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Registro.this, "El registro se realizó exitosamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registro.this, "No se pudo crear el cliente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
    void saveUser(String id,String nombre, String correo){

        String selectedUser=mPref.getString("user","");
        User user=new User();
        user.setCorreo(correo);
        user.setNombre(nombre);

        if(selectedUser.equals("conductor")){
            mDatabase.child("Users").child("Conductores").child(id).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Registro.this, "Falló el registro", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else if(selectedUser.equals("pasajero")){
            mDatabase.child("Users").child("Clientes").child(id).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Registro.this, "Falló el registro", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        }
        */

}



