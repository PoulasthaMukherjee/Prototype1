package com.example.prototype1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_tow.*

class TowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tow)

        val passedData : String? = intent.getStringExtra("data")

        tvSecond.text = passedData
        if (passedData != null) {
            Log.e("passed data", passedData)
        }
    }
}