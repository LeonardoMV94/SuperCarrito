package com.proyectoapp.supercarrito.presentador;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.adaptadores.RecyclerProductoAdapter;
import com.proyectoapp.supercarrito.modelo.Producto;

import java.util.ArrayList;

public class PresentadorStock {

    private Context mContext;
    private DatabaseReference mDatabase;
    private RecyclerProductoAdapter mAdaptadorRecycler;

    public PresentadorStock(Context mContext, DatabaseReference mDatabase) {
        this.mContext = mContext;
        this.mDatabase = mDatabase;
    }

    public  void cargarRecyclerView(final RecyclerView mRecyclerView){
        mDatabase.child("Productos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList<Producto> arrayListProductos = new ArrayList<>();

                for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                    Producto producto = snapshot.getValue(Producto.class);

                            producto.setCodigoBarras(producto.getCodigoBarras());
                            producto.setMarca(producto.getMarca());
                            producto.setNombreo(producto.getNombreo());
                            producto.setPrecio(producto.getPrecio());
                            producto.setCantidad(producto.getCantidad());

                    arrayListProductos.add(producto);
                }

                Log.i("Datos", arrayListProductos.toString());

                mAdaptadorRecycler = new RecyclerProductoAdapter(mContext, R.layout.producto_row,arrayListProductos);
                mRecyclerView.setAdapter(mAdaptadorRecycler);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void cargarProductos() {


    }
}
