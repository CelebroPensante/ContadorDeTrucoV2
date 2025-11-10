package com.example.contadordetruco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.media.MediaPlayer

class JogoActivity : AppCompatActivity() {
    var pontosEquipe1 = 0
    var pontosEquipe2 = 0

    // guarda o player atual para poder liberar quando necessário
    private var currentPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        // Lista com os áudios da pasta raw (para som aleatório ao marcar ponto)
        val sons = listOf(
            R.raw.risada1,
            R.raw.risada2,
            R.raw.risada3,
            R.raw.risada4,
            R.raw.risada5,
            R.raw.risada6,
            R.raw.risada7,
            R.raw.risada8,
            R.raw.risada9,
            R.raw.risada10,
            R.raw.risada11,
            R.raw.risada12
        )

        fun tocarSomAleatorio() {
            // libera qualquer player anterior antes de criar outro
            currentPlayer?.release()

            val somAleatorio = sons.random()
            currentPlayer = MediaPlayer.create(this, somAleatorio)
            currentPlayer?.start()
            currentPlayer?.setOnCompletionListener {
                it.release()
                currentPlayer = null
            }
        }

        // Função para tocar som específico ao subtrair
        fun tocarSomSubtracao() {
            // nome do recurso: res/raw/subtrair.mp3 -> R.raw.subtrair
            // libera player anterior
            currentPlayer?.release()

            currentPlayer = MediaPlayer.create(this, R.raw.subtrair)
            currentPlayer?.start()
            currentPlayer?.setOnCompletionListener {
                it.release()
                currentPlayer = null
            }
        }

        val placarEquipe1 = findViewById<TextView>(R.id.placarEquipe1)
        val placarEquipe2 = findViewById<TextView>(R.id.placarEquipe2)

        placarEquipe1.text = "0"
        placarEquipe2.text = "0"

        fun atualizarPlacar() {
            placarEquipe1.text = pontosEquipe1.toString()
            placarEquipe2.text = pontosEquipe2.toString()

            if (pontosEquipe1 >= 12) {
                val intent = Intent(this, VitoriaActivity::class.java)
                intent.putExtra("vencedor", "Equipe 1")
                startActivity(intent)
                finish()
            }

            if (pontosEquipe2 >= 12) {
                val intent = Intent(this, VitoriaActivity::class.java)
                intent.putExtra("vencedor", "Equipe 2")
                startActivity(intent)
                finish()
            }
        }

        // --- Botões Equipe 1 (adição) ---
        findViewById<Button>(R.id.btnE1_1).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 + 1).coerceAtMost(12)
            tocarSomAleatorio()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_3).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 + 3).coerceAtMost(12)
            tocarSomAleatorio()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_6).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 + 6).coerceAtMost(12)
            tocarSomAleatorio()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_9).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 + 9).coerceAtMost(12)
            tocarSomAleatorio()
            atualizarPlacar()
        }

        // --- Botões Equipe 2 (adição) ---
        findViewById<Button>(R.id.btnE2_1).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 + 1).coerceAtMost(12)
            tocarSomAleatorio()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_3).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 + 3).coerceAtMost(12)
            tocarSomAleatorio()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_6).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 + 6).coerceAtMost(12)
            tocarSomAleatorio()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_9).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 + 9).coerceAtMost(12)
            tocarSomAleatorio()
            atualizarPlacar()
        }

        // --- Subtração Equipe 1 ---
        findViewById<Button>(R.id.btnE1_S1).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 - 1).coerceAtLeast(0)
            tocarSomSubtracao()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_S3).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 - 3).coerceAtLeast(0)
            tocarSomSubtracao()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_S6).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 - 6).coerceAtLeast(0)
            tocarSomSubtracao()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_S9).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 - 9).coerceAtLeast(0)
            tocarSomSubtracao()
            atualizarPlacar()
        }

        // --- Subtração Equipe 2 ---
        findViewById<Button>(R.id.btnE2_S1).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 - 1).coerceAtLeast(0)
            tocarSomSubtracao()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_S3).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 - 3).coerceAtLeast(0)
            tocarSomSubtracao()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_S6).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 - 6).coerceAtLeast(0)
            tocarSomSubtracao()
            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_S9).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 - 9).coerceAtLeast(0)
            tocarSomSubtracao()
            atualizarPlacar()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        // garante que o player seja liberado ao destruir a Activity
        currentPlayer?.release()
        currentPlayer = null
    }
}
