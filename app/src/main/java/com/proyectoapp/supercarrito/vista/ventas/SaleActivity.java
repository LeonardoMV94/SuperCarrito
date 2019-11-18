package com.proyectoapp.supercarrito.vista.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.proyectoapp.supercarrito.R;



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

    }

}