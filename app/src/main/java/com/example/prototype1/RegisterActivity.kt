package com.example.prototype1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()


        btnRegister.setOnClickListener {

            if(editEmail.text.isNotEmpty() && editCPassword.text.isNotEmpty() && editPassword.text.isNotEmpty()){
                registerUser()

            }else{
                Toast.makeText(this,"Input Required", Toast.LENGTH_LONG).show()

            }

        }


        tvLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun registerUser(){

        auth.createUserWithEmailAndPassword(editEmail.text.trim().toString(), editPassword.text.trim().toString())
            .addOnCompleteListener (this) {
                task ->
                if(task.isSuccessful){

                    Toast.makeText(this,"Register Successful",Toast.LENGTH_LONG).show()

                }else{

                    Toast.makeText(this,"Register Failed "+task.exception,Toast.LENGTH_LONG).show()


                }
            }


    }

    override fun onStart() {
        super.onStart()

        val user = auth.currentUser

//        if (user != null){
//
//            val intent = Intent(this, DashboardActivity::class.java)
//            startActivity(intent)
//
//        }else{
//            Log.e("user status", "User null")
//        }
    }
}