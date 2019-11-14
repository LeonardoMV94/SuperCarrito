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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.proyectoapp.supercarrito.R


class RegisterActivity : AppCompatActivity() {

    private lateinit var txtName:EditText
    private lateinit var txtLastName:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtPassword:EditText
    private lateinit var progressBar:ProgressBar
    private lateinit var dbReference:DatabaseReference
    private lateinit var database:FirebaseDatabase
    private lateinit var auth:FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //quitar Titulo de app de la parte superior  --Leonardo
        supportActionBar?.hide()



        txtName=findViewById(R.id.txtName)
        txtLastName=findViewById(R.id.txtLastName)
        txtEmail=findViewById(R.id.txtEmail)
        txtPassword=findViewById(R.id.txtPassword)

        progressBar= findViewById(R.id.progressBar)

        database=FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()
        dbReference=database.reference.child("User")
    }

    fun register(@Suppress("UNUSED_PARAMETER")view: View){
        createNewAccount()
    }

    private fun createNewAccount(){
        val name:String=txtName.text.toString()
        val lastName:String=txtLastName.text.toString()
        val email:String=txtEmail.text.toString()
        val password:String=txtPassword.text.toString()

       if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(lastName)
           && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            progressBar.visibility=View.VISIBLE

            try{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){
                            task ->

                        if (task.isComplete){
                            val user:FirebaseUser?=auth.currentUser
                            verifyEmail(user)

                            val userBD=dbReference.child(user?.uid!!)
                            userBD.child("Name").setValue(name)
                            userBD.child("LastName").setValue(lastName)

                            Toast.makeText(this,"Registrado exitosamente",Toast.LENGTH_LONG).show()

                            action()
                        }
                    }
            } catch (r: RuntimeException){
                Toast.makeText(this,"Error: " + r.message ,Toast.LENGTH_LONG).show()
            } catch (e: Exception){
                Toast.makeText(this,"Error: " + e.message ,Toast.LENGTH_LONG).show()
            }

       }
    }

    private fun action(){
            startActivity(Intent(this, LoginActivity::class.java))
        Toast.makeText(this,"Ya puede iniciar sesión",Toast.LENGTH_LONG).show()
    }

    private fun verifyEmail(user:FirebaseUser?){
            user?.sendEmailVerification()
                ?.addOnCompleteListener(this){
                    task ->
                    if (task.isComplete){
                        Toast.makeText(this,"Email enviado",Toast.LENGTH_LONG).show()
                    } else{
                        Toast.makeText(this,"Error al enviar el email",Toast.LENGTH_LONG).show()
                    }
                }
    }

}
