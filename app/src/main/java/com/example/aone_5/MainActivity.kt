package com.example.aone_5

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buEnableRec.setOnClickListener {
            if (Build.VERSION.SDK_INT >= 23){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS),
                1)
            }else{
                Toast.makeText(this, "Sorry You Device Before Android 6", Toast.LENGTH_SHORT).show()
            }
        }
    }
}