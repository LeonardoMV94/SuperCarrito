package com.proyectoapp.supercarrito.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.proyectoapp.supercarrito.modelo.Producto;
import com.proyectoapp.supercarrito.presentador.interfaces.FirebaseSuccessListener;


public class TraerDatosFirebase {

    //https://youtu.be/lI2tLNs4nUc

    private static final String TAG = "TraerDatosFirebase";
    private Context mContext;
    private FirebaseSuccessListener mSuccessListener;


    public TraerDatosFirebase(Context mContext) {
        this.mContext = mContext;
    }

    public void setInterfaz( FirebaseSuccessListener interfaz){
        this.mSuccessListener = interfaz;
    }

    public void getDatosFirebase(final DatabaseReference mDatabase){
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren() ) {
                    Producto producto = snapshot.getValue(Producto.class);

                    assert producto != null;
                    String codigoBarras= producto.getCodigoBarras();
                    String marcaProducto= producto.getMarca();
                    String nombreProducto= producto.getNombreo();
                    int precioProducto= producto.getPrecio();
                    int cantidadProducto= producto.getCantidad();

                    Log.i(TAG,"onDataChange: " + producto.toString());



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
