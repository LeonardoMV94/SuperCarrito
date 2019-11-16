package com.proyectoapp.supercarrito.vista.entrada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.proyectoapp.supercarrito.R;

public class EntradaActivity extends AppCompatActivity{

    private Button btnCaptureCode;
    private Button btnGuardarDatos;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escaneo);

        btnCaptureCode = findViewById(R.id.btnScan);
        btnCaptureCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SimpleScannerActivity.class);
                startActivity(intent);
            }
        });

        btnGuardarDatos = findViewById(R.id.btnGuardarProducto);
        btnGuardarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action();
            }
        });

        Bundle datos = this.getIntent().getExtras();
        if (datos != null){
            String datosObtenidos = getIntent().getStringExtra("codigoBarras");
            TextView txtCod =  findViewById(R.id.txtCodigo);
            txtCod.setText(datosObtenidos);
        }

    }


    private void action(){
        TextView txtCodigoBarras = findViewById(R.id.txtCodigo);
        EditText txtNombreProd = findViewById(R.id.editNombre);
        EditText txtPrec = findViewById(R.id.editPrecio);
        EditText txtCant = findViewById(R.id.editCantidad);

        String cod = txtCodigoBarras.getText().toString();
        String name = txtNombreProd.getText().toString();
        String prec = txtPrec.getText().toString();
        String cant = txtCant.getText().toString();

        if (!cod.equalsIgnoreCase("")
        && !name.equalsIgnoreCase("")
        && !prec.equalsIgnoreCase("")
        && !cant.equalsIgnoreCase("") ){
            Toast.makeText(this,"Datos Ingresados !!",Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this,"Faltan datos por ingresar",Toast.LENGTH_LONG).show();
        }



    }



}
