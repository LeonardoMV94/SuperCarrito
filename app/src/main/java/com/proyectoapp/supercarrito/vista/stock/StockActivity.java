package com.proyectoapp.supercarrito.vista.stock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.adaptadores.RecyclerProductoAdapter;
import com.proyectoapp.supercarrito.presentador.PresentadorStock;
import com.proyectoapp.supercarrito.presentador.TraerDatosFirebase;

public class StockActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference databaseReference;
    private PresentadorStock presentadorStock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        presentadorStock=new PresentadorStock(this,databaseReference);

        FloatingActionButton floatingActionButton = findViewById(R.id.fabStock);
        floatingActionButton.setOnClickListener(this);


            //seguir video
            //https://youtu.be/3J4Wv9mGnu0?t=1042


    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewStock);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        presentadorStock.cargarRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fabStock:
                initRecyclerView();
                break;

        }
    }
}
