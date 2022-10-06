package com.example.general

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getdata=findViewById<Button>(R.id.get_api)

        // fetch data
        getdata.setOnClickListener(){
        val intent=Intent(this, GetApiActivity::class.java)
            startActivity(intent)
        }

        // for post activty

    }
}