package com.example.contadordetruco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class VitoriaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vitoria)

        val vencedor = intent.getStringExtra("vencedor")
        val txtVencedor = findViewById<TextView>(R.id.txtVencedor)
        val btnNovoJogo = findViewById<Button>(R.id.btnNovoJogo)

        txtVencedor.text = "$vencedor venceu! 🎉"

        btnNovoJogo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
