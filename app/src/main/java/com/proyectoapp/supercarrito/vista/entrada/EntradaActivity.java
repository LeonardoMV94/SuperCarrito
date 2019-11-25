package com.proyectoapp.supercarrito.vista.entrada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.presentador.IngresarDatosFIrebase;
import com.proyectoapp.supercarrito.vista.resumen.ResumenActivity;
import com.proyectoapp.supercarrito.vista.stock.StockActivity;

public class EntradaActivity extends AppCompatActivity {

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

        BottomNavigationView bottomNavigationMenu = findViewById(R.id.bottom_navigation_view);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_add_producto:
                        Intent intent = new Intent(EntradaActivity.this, EntradaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_stock_productos:
                        Intent intent2 = new Intent(EntradaActivity.this, StockActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_resume_productos:
                        Intent intent3 = new Intent(EntradaActivity.this, ResumenActivity.class);
                        startActivity(intent3);
                        break;
                }

                return false;
            }
        });

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
            txtCodigoBarras.setText("codigo");
            txtMarcaProd.setText("");
            txtNombreProd.setText("");
            txtPrec.setText("");
            txtCant.setText("");

        } else{
            Toast.makeText(this,"Faltan datos por ingresar",Toast.LENGTH_LONG).show();
        }



    }



}
