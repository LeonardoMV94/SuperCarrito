package com.proyectoapp.supercarrito.vista.ventas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.vista.Main2Activity;
import com.proyectoapp.supercarrito.vista.entrada.EntradaActivity;
import com.proyectoapp.supercarrito.vista.resumen.ResumenActivity;
import com.proyectoapp.supercarrito.vista.stock.StockActivity;


public class SaleActivity extends AppCompatActivity {

    private Button btnCaptureCod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);

        btnCaptureCod = findViewById(R.id.btnAgregarSale);
        btnCaptureCod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SimpleScannerSalesActivity.class);
                startActivity(intent);
            }
        });


        Bundle datos = this.getIntent().getExtras();
        if (datos != null){
            String datosObtenidos = getIntent().getStringExtra("codigoBarras");
            TextView txtCod =  findViewById(R.id.txtCodigoSale);
            txtCod.setText(datosObtenidos);
        }


        BottomNavigationView bottomNavigationMenu = findViewById(R.id.bottom_navigation_view);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_add_producto:
                        Intent intent = new Intent(SaleActivity.this, EntradaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_stock_productos:
                        Intent intent2 = new Intent(SaleActivity.this, StockActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_resume_productos:
                        Intent intent3 = new Intent(SaleActivity.this, ResumenActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_sale_productos:
                        Intent intent4 = new Intent(SaleActivity.this, SaleActivity.class);
                        startActivity(intent4);
                        break;
                }

                return false;
            }
        });


    }

}