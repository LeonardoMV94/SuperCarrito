package com.proyectoapp.supercarrito.vista.stock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.adaptadores.RecyclerProductoAdapter;
import com.proyectoapp.supercarrito.presentador.PresentadorStock;
import com.proyectoapp.supercarrito.presentador.TraerDatosFirebase;
import com.proyectoapp.supercarrito.vista.Main2Activity;
import com.proyectoapp.supercarrito.vista.entrada.EntradaActivity;
import com.proyectoapp.supercarrito.vista.resumen.ResumenActivity;
import com.proyectoapp.supercarrito.vista.ventas.SaleActivity;

public class StockActivity extends AppCompatActivity implements View.OnClickListener  {
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

        BottomNavigationView bottomNavigationMenu = findViewById(R.id.bottom_navigation_view);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_add_producto:
                        Intent intent = new Intent(StockActivity.this, EntradaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_stock_productos:
                        Intent intent2 = new Intent(StockActivity.this, StockActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_resume_productos:
                        Intent intent3 = new Intent(StockActivity.this, ResumenActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.action_sale_productos:
                        Intent intent4 = new Intent(StockActivity.this, SaleActivity.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });

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
