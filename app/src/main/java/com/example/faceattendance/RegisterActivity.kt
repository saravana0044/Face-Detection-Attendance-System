package com.example.faceattendance

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val name = findViewById<EditText>(R.id.etName)
        val admission = findViewById<EditText>(R.id.etAdmission)
        val studentClass = findViewById<EditText>(R.id.etClass)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            if (name.text.isBlank() || admission.text.isBlank() || studentClass.text.isBlank()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Portfolio/demo version: persist student details with SharedPreferences.
            getSharedPreferences("students", MODE_PRIVATE).edit()
                .putString("name", name.text.toString())
                .putString("admission", admission.text.toString())
                .putString("class", studentClass.text.toString())
                .apply()

            Toast.makeText(this, "Student registered", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
