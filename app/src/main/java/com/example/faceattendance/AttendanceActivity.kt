package com.example.faceattendance

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions

class AttendanceActivity : AppCompatActivity() {

    private lateinit var status: TextView

    companion object {
        private const val CAMERA_REQUEST = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        status = findViewById(R.id.txtCameraStatus)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_REQUEST
            )
        } else {
            status.text = "Camera permission granted. Ready."
        }

        findViewById<Button>(R.id.btnDetect).setOnClickListener {
            runFaceDetectionDemo()
        }

        findViewById<Button>(R.id.btnMark).setOnClickListener {
            val prefs = getSharedPreferences("students", MODE_PRIVATE)
            val name = prefs.getString("name", null)

            if (name == null) {
                Toast.makeText(this, "Register a student first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val time = java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss",
                java.util.Locale.getDefault()
            ).format(java.util.Date())

            getSharedPreferences("attendance", MODE_PRIVATE).edit()
                .putString("last_attendance", "$name | $time")
                .apply()

            status.text = "Attendance marked for $name at $time"
        }
    }

    private fun runFaceDetectionDemo() {
        // Demonstrates the ML Kit detector setup. A real camera frame should be
        // converted to InputImage and passed to detector.process(image).
        val options = FaceDetectorOptions.Builder()
            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
            .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
            .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
            .build()

        val detector = FaceDetection.getClient(options)
        detector.close()

        status.text =
            "ML Kit face detector initialized. Connect CameraX/Camera2 frames to InputImage for live detection."
    }
}
