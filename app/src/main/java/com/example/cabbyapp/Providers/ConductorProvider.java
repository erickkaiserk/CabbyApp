package com.example.cabbyapp.Providers;

import com.example.cabbyapp.Modelo.Cliente;
import com.example.cabbyapp.Modelo.Conductor;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConductorProvider {

    DatabaseReference mDatabase;

    public ConductorProvider() {
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Users").child("Clientes");
    }

    public Task<Void> create(Conductor conductor){
        return mDatabase.child(conductor.getId()).setValue(conductor);
    }
}
