package com.proyectoapp.supercarrito.presentador;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.proyectoapp.supercarrito.adaptadores.RecyclerProductoAdapter;

public class PresentadorStock {

    private Context mContext;
    private DatabaseReference mDatabase;
    private RecyclerView mRecyclerView;
    private RecyclerProductoAdapter mAdaptadorRecycler;

    public PresentadorStock(Context mContext, DatabaseReference mDatabase) {
        this.mContext = mContext;
        this.mDatabase = mDatabase;
    }

    public void cargarProductos() {


    }
}
