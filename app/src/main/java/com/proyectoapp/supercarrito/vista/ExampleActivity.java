package com.proyectoapp.supercarrito.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proyectoapp.supercarrito.R;
import com.proyectoapp.supercarrito.presentador.TraerDatosFirebase;

public class ExampleActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        TraerDatosFirebase traerDatosFirebase = new TraerDatosFirebase(this);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Productos");

        traerDatosFirebase.getDatosFirebase(databaseReference);



    }
}
