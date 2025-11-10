package com.example.contadordetruco

import android.widget.TextView
import android.media.MediaPlayer
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPontuador = findViewById<Button>(R.id.btn_pontuador)
        btnPontuador.setOnClickListener {

            val intent = Intent(this, JogoActivity::class.java)
            startActivity(intent)
        }

        val btnSorteio = findViewById<Button>(R.id.btn_sorteio)
        btnSorteio.setOnClickListener {
            val intent = Intent(this, SorteioActivity::class.java)
            startActivity(intent)
        }

    }
}