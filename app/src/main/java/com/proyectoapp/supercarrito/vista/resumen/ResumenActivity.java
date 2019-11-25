package com.proyectoapp.supercarrito.vista.resumen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.vista.Main2Activity;
import com.proyectoapp.supercarrito.vista.entrada.EntradaActivity;
import com.proyectoapp.supercarrito.vista.stock.StockActivity;
import com.proyectoapp.supercarrito.vista.ventas.SaleActivity;

public class ResumenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);


        BottomNavigationView bottomNavigationMenu = findViewById(R.id.bottom_navigation_view);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_add_producto:
                        Intent intent = new Intent(ResumenActivity.this, EntradaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_stock_productos:
                        Intent intent2 = new Intent(ResumenActivity.this, StockActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_resume_productos:
                        Intent intent3 = new Intent(ResumenActivity.this, ResumenActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_sale_productos:
                        Intent intent4 = new Intent(ResumenActivity.this, SaleActivity.class);
                        startActivity(intent4);
                        break;

                }

                return false;
            }
        });
    }


}
