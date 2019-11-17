package com.proyectoapp.supercarrito.vista.entrada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.presentador.IngresarDatosFIrebase;

public class EntradaActivity extends AppCompatActivity{

    private Button btnCaptureCode;
    private Button btnGuardarDatos;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escaneo);

        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();


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
        EditText txtMarcaProd = findViewById(R.id.editMarca);
        EditText txtNombreProd = findViewById(R.id.editNombre);
        EditText txtPrec = findViewById(R.id.editPrecio);
        EditText txtCant = findViewById(R.id.editCantidad);

        String cod = txtCodigoBarras.getText().toString();
        String marc = txtMarcaProd.getText().toString();
        String name = txtNombreProd.getText().toString();
        String prec = txtPrec.getText().toString();
        String cant = txtCant.getText().toString();

        if (!cod.equalsIgnoreCase("")
        && !marc.equalsIgnoreCase("")
        && !name.equalsIgnoreCase("")
        && !prec.equalsIgnoreCase("")
        && !cant.equalsIgnoreCase("") ){
            IngresarDatosFIrebase ingresarDatosFIrebase = new IngresarDatosFIrebase(this,mDatabase,mAuth);
            ingresarDatosFIrebase.ingresarProductos(cod, marc,name, prec, cant);
        } else{
            Toast.makeText(this,"Faltan datos por ingresar",Toast.LENGTH_LONG).show();
        }



    }



}
