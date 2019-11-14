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
import com.proyectoapp.supercarrito.vista.MainActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var txtUser: EditText
    private lateinit var txtPass: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //quitar Titulo de app de la parte superior  --Leonardo
        supportActionBar?.hide()


        txtUser=findViewById(R.id.txtUser)
        txtPass=findViewById(R.id.txtPass)
        progressBar= findViewById(R.id.progressBar)


        auth= FirebaseAuth.getInstance()
    }

    fun forgotPassword(@Suppress("UNUSED_PARAMETER")view: View){
        startActivity(Intent(this, ForgotPassActivity::class.java))
    }

    fun register(@Suppress("UNUSED_PARAMETER")view: View){
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    fun login(@Suppress("UNUSED_PARAMETER")view: View){
        loginUser()
    }
    private fun loginUser(){
        val user:String=txtUser.text.toString()
        val pass:String=txtPass.text.toString()

        if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)){
            progressBar.visibility=View.VISIBLE

            auth.signInWithEmailAndPassword(user,pass)
                .addOnCompleteListener(this){
                    task ->
                    if (task.isSuccessful){
                        action()
                    } else{
                        Toast.makeText(this,"Error en la autenticación", Toast.LENGTH_LONG).show()
                        progressBar.visibility=View.INVISIBLE
                    }
                }
        }
    }

    private fun action(){
        startActivity(Intent(this, MainActivity::class.java))
    }
}
