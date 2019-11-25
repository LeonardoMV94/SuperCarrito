package com.proyectoapp.supercarrito.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.vista.entrada.EntradaActivity;
import com.proyectoapp.supercarrito.vista.resumen.ResumenActivity;
import com.proyectoapp.supercarrito.vista.stock.StockActivity;

public class Main2Activity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView bottomNavigationMenu = findViewById(R.id.bottom_navigation_view);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_add_producto:
                        Intent intent = new Intent(Main2Activity.this, EntradaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_stock_productos:
                        Intent intent2 = new Intent(Main2Activity.this, StockActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_resume_productos:
                        Intent intent3 = new Intent(Main2Activity.this, ResumenActivity.class);
                        startActivity(intent3);
                        break;
                }

                return false;
            }
        });

    }


}
