package com.proyectoapp.supercarrito.presentador;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.proyectoapp.supercarrito.modelo.Usuario;

public class PresentadorUsuario {

    private Context mContext;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    public PresentadorUsuario(Context mContext, DatabaseReference mDatabase, FirebaseAuth mAuth) {
        this.mContext = mContext;
        this.mDatabase = mDatabase;
        this.mAuth = mAuth;
    }

    public void welcomeMensaje(){
        mDatabase.child("User").child(mAuth.getCurrentUser().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Usuario user = dataSnapshot.getValue(Usuario.class);
                        Toast.makeText(mContext,"Bienvenido " +user.getNombre() + " " + user.getApellido()
                        ,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }
}
