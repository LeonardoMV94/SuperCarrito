package com.proyectoapp.supercarrito.vista.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import com.proyectoapp.supercarrito.R
import com.proyectoapp.supercarrito.vista.login.LoginActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //quitar Titulo de app de la parte superior  --Leonardo
        supportActionBar?.hide()

        //comentario de lucas
        //comantario numero2 de lucas

        //El logo de la app es provisorio, se puede cambiar mas adelante

        //Abrir activity Login despues de 2 segundos
         Handler().postDelayed(Runnable { startActivity(Intent(this,
             LoginActivity::class.java)) },2000)

    }
}
