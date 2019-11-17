package com.proyectoapp.supercarrito.vista.ventas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.zxing.Result;
import com.proyectoapp.supercarrito.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SaleActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView escannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
    }

    public void Escanear(View view ){
    escannerView=new ZXingScannerView(this);
    setContentView(escannerView);
    escannerView.setResultHandler(this);
    escannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        escannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Resultado del scanner");
        builder.setMessage(result.getText());
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        escannerView.resumeCameraPreview(this);

    }
    }