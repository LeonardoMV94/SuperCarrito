package com.proyectoapp.supercarrito.presentador;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import java.util.HashMap;
import java.util.Map;


public class IngresarDatosFIrebase {

    private Context mContext;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;


    public IngresarDatosFIrebase(Context mContext, DatabaseReference mDatabase, FirebaseAuth mAuth) {
        this.mContext = mContext;
        this.mDatabase = mDatabase;
        this.mAuth = mAuth;
    }

    public void ingresarProductos(String cod,String marca,String nombre,String precio, String cantidad) {

        int pre = Integer.parseInt(precio);
        int cant= Integer.parseInt(cantidad);

        this.cargarProductoFirebase(cod,marca,nombre,pre,cant);

    }

    private void cargarProductoFirebase(String codigo, String marca, String nombre, int precio, int cantidad){

        Map<String,Object> producto = new HashMap<>();
        producto.put("codigoBarras",codigo);
        producto.put("marca",marca);
        producto.put("nombreo",nombre);
        producto.put("precio",precio);
        producto.put("cantidad",cantidad);


        mDatabase.child("Productos").child(codigo).updateChildren(producto)
        .addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(mContext,"Ingresado Correctamente ! " ,Toast.LENGTH_LONG).show();
                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(mContext,"Error al ingresar" + e.getMessage() ,Toast.LENGTH_LONG).show();
            }
        });


    }
}
