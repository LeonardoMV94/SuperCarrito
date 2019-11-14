package com.proyectoapp.supercarrito.vista.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import com.proyectoapp.supercarrito.R
import com.proyectoapp.supercarrito.isValidEmail


class ForgotPassActivity : AppCompatActivity() {

    private lateinit var txtEmail: EditText
    private lateinit var auth:FirebaseAuth
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        //quitar Titulo de app de la parte superior  --Leonardo
        supportActionBar?.hide()


        txtEmail=findViewById(R.id.txtEmail)
        auth=FirebaseAuth.getInstance()
        progressBar= findViewById(R.id.progressBar)
    }

    fun send(@Suppress("UNUSED_PARAMETER")view: View) {
        val email=txtEmail.text.toString()

        if (!TextUtils.isEmpty(email) && isValidEmail(email)){
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this){
                    task ->

                    if (task.isSuccessful){
                        progressBar.visibility=View.VISIBLE
                        startActivity(Intent(this,
                            LoginActivity::class.java))

                    } else{
                        Toast.makeText(this,"Error al enviar el email", Toast.LENGTH_LONG).show()
                    }
                }
        } else{
            Toast.makeText(this,"Email invalido", Toast.LENGTH_LONG).show()
        }
    }
}
