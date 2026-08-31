package com.example.faceattendance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val status = findViewById<TextView>(R.id.txtStatus)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        findViewById<Button>(R.id.btnAttendance).setOnClickListener {
            status.text = "Status: Opening face detection..."
            startActivity(Intent(this, AttendanceActivity::class.java))
        }
    }
}
