package com.proyectoapp.supercarrito.presentador;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.proyectoapp.supercarrito.vista.entrada.EntradaActivity;
import com.proyectoapp.supercarrito.vista.login.LoginActivity;

import java.util.concurrent.Executor;




public class PresentadorLogin {


    private Context mContext;
    private String TAG = "PresentadorLogin";
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public PresentadorLogin(final Context mContext, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mDatabase = mDatabase;


    //https://youtu.be/SRU4iXC5oCw?t=1369

    }

    public void iniciarSesion(String email,String password){

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");

                                    mDatabase.child("User").setValue(task.getResult().getUser().getUid());
                                    Intent intent = new Intent(mContext, EntradaActivity.class);
                                    mContext.startActivity(intent);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(mContext, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }


                            }
                        });


    }




}
