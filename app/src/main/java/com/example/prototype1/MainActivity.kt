package com.example.prototype1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()


        btnLogin.setOnClickListener {

            if (edUsername.text.trim().isNotEmpty() || edPassword.text.trim().isNotEmpty()){
                //
                signInUser()
            }else{
                Toast.makeText(this,"Input required",Toast.LENGTH_LONG).show()

            }

        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signInUser(){
        auth.signInWithEmailAndPassword(edUsername.text.trim().toString(),edPassword.text.trim().toString())
            .addOnCompleteListener (this) {
                task ->
                if(task.isSuccessful){
                    val intent = Intent(this,DashboardActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Authentication Error "+task.exception, Toast.LENGTH_LONG).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
//        if(user != null){
//            val intent = Intent(this,DashboardActivity::class.java)
//            startActivity(intent)
//
//        }else{
//            Toast.makeText(this,"User first time login",Toast.LENGTH_LONG).show()
//        }
    }
}