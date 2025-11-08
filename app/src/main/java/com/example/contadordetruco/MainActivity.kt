package com.example.contadordetruco

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var pontosEquipe1 = 0
    var pontosEquipe2 = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val placarEquipe1 = findViewById<TextView>(R.id.placarEquipe1)
        val placarEquipe2 = findViewById<TextView>(R.id.placarEquipe2)

        placarEquipe1.text = "0"
        placarEquipe2.text = "0"

        // Botões Equipe 1
        findViewById<Button>(R.id.btnE1_1).setOnClickListener {
            pontosEquipe1 += 1
            placarEquipe1.text = pontosEquipe1.toString()
        }

        findViewById<Button>(R.id.btnE1_3).setOnClickListener {
            pontosEquipe1 += 3
            placarEquipe1.text = pontosEquipe1.toString()
        }

        findViewById<Button>(R.id.btnE1_6).setOnClickListener {
            pontosEquipe1 += 6
            placarEquipe1.text = pontosEquipe1.toString()
        }

        findViewById<Button>(R.id.btnE1_9).setOnClickListener {
            pontosEquipe1 += 9
            placarEquipe1.text = pontosEquipe1.toString()
        }

        // Botões Equipe 2
        findViewById<Button>(R.id.btnE2_1).setOnClickListener {
            pontosEquipe2 += 1
            placarEquipe2.text = pontosEquipe2.toString()
        }

        findViewById<Button>(R.id.btnE2_3).setOnClickListener {
            pontosEquipe2 += 3
            placarEquipe2.text = pontosEquipe2.toString()
        }

        findViewById<Button>(R.id.btnE2_6).setOnClickListener {
            pontosEquipe2 += 6
            placarEquipe2.text = pontosEquipe2.toString()
        }

        findViewById<Button>(R.id.btnE2_9).setOnClickListener {
            pontosEquipe2 += 9
            placarEquipe2.text = pontosEquipe2.toString()
        }
    }
}
