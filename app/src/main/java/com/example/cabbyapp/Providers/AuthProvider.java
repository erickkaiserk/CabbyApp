package com.example.cabbyapp.Providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthProvider {

    FirebaseAuth mAuth;

    public AuthProvider() {
        mAuth=FirebaseAuth.getInstance();
    }

    public Task<AuthResult> register(String correo, String password){
        return  mAuth.createUserWithEmailAndPassword(correo,password);
    }

    public Task<AuthResult> login(String correo, String password){
        return  mAuth.signInWithEmailAndPassword(correo,password);
    }
}
