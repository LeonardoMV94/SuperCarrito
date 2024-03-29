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
import com.google.firebase.database.FirebaseDatabase
import com.proyectoapp.supercarrito.R
import com.proyectoapp.supercarrito.presentador.PresentadorUsuario
import com.proyectoapp.supercarrito.vista.ExampleActivity
import com.proyectoapp.supercarrito.vista.Main2Activity
import com.proyectoapp.supercarrito.vista.entrada.EntradaActivity
import com.proyectoapp.supercarrito.vista.stock.StockActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var txtUser: EditText
    private lateinit var txtPass: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth
    private lateinit var mDatabase: FirebaseDatabase
    private lateinit var presentadorUsuario: PresentadorUsuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //quitar Titulo de app de la parte superior  --Leonardo
        supportActionBar?.hide()


        txtUser = findViewById(R.id.txtUser)
        txtPass = findViewById(R.id.txtPass)
        progressBar = findViewById(R.id.progressBar)

        auth = FirebaseAuth.getInstance()


    }


    fun forgotPassword(@Suppress("UNUSED_PARAMETER") view: View) {
        startActivity(Intent(this, ForgotPassActivity::class.java))
    }

    fun register(@Suppress("UNUSED_PARAMETER") view: View) {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    fun login(@Suppress("UNUSED_PARAMETER") view: View) {
        loginUser()
    }

    private fun loginUser() {


        val user: String = txtUser.text.toString()
        val pass: String = txtPass.text.toString()

        if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
            progressBar.visibility = View.VISIBLE

            auth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // presentadorUsuario = PresentadorUsuario(this,mDatabase,auth)
                        Toast.makeText(this, "Bienvenido! $user", Toast.LENGTH_LONG).show()
                        action()
                    } else {
                        Toast.makeText(this, "Error en la autenticación", Toast.LENGTH_LONG).show()
                        progressBar.visibility = View.INVISIBLE
                    }
                }
        } else {
            Toast.makeText(this, "Ingrese datos en ambos campos", Toast.LENGTH_LONG).show()
        }


    }

    private fun action() {
        startActivity(Intent(this, Main2Activity::class.java))
    }
}
