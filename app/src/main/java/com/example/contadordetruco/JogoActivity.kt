package com.example.contadordetruco

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.media.MediaPlayer

class JogoActivity : AppCompatActivity() {
    var pontosEquipe1 = 0
    var pontosEquipe2 = 0

    // Variáveis para armazenar os nomes das equipes
    private var nomeEquipe1 = "Equipe 1"
    private var nomeEquipe2 = "Equipe 2"

    // guarda o player atual para poder liberar quando necessário
    private var currentPlayer: MediaPlayer? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        // Receber os dados das duplas
        receberDadosDuplas()
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

        val placarEquipe1 = findViewById<TextView>(R.id.placarEquipe1)
        val placarEquipe2 = findViewById<TextView>(R.id.placarEquipe2)

        // Atualizar os textos das equipes
        val textoEquipe1 = findViewById<TextView>(R.id.textoEquipe1)
        val textoEquipe2 = findViewById<TextView>(R.id.textoEquipe2)
        textoEquipe1.text = nomeEquipe1
        textoEquipe2.text = nomeEquipe2

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

            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_S3).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 - 3).coerceAtLeast(0)

            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_S6).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 - 6).coerceAtLeast(0)

            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE1_S9).setOnClickListener {
            pontosEquipe1 = (pontosEquipe1 - 9).coerceAtLeast(0)

            atualizarPlacar()
        }

        // --- Subtração Equipe 2 ---
        findViewById<Button>(R.id.btnE2_S1).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 - 1).coerceAtLeast(0)

            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_S3).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 - 3).coerceAtLeast(0)

            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_S6).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 - 6).coerceAtLeast(0)

            atualizarPlacar()
        }

        findViewById<Button>(R.id.btnE2_S9).setOnClickListener {
            pontosEquipe2 = (pontosEquipe2 - 9).coerceAtLeast(0)

            atualizarPlacar()
        }

    }

    private fun receberDadosDuplas() {
        nomeEquipe1 = intent.getStringExtra("NOME_EQUIPE1") ?: "Equipe 1"
        nomeEquipe2 = intent.getStringExtra("NOME_EQUIPE2") ?: "Equipe 2"

        // Você pode salvar os emails se quiser usar depois
        val emailEquipe1Jogador1 = intent.getStringExtra("EMAIL_EQUIPE1_JOGADOR1") ?: ""
        val emailEquipe1Jogador2 = intent.getStringExtra("EMAIL_EQUIPE1_JOGADOR2") ?: ""
        val emailEquipe2Jogador1 = intent.getStringExtra("EMAIL_EQUIPE2_JOGADOR1") ?: ""
        val emailEquipe2Jogador2 = intent.getStringExtra("EMAIL_EQUIPE2_JOGADOR2") ?: ""

        // Aqui você pode fazer o que quiser com os emails (salvar no SharedPreferences, etc.)
    }

    override fun onDestroy() {
        super.onDestroy()
        // garante que o player seja liberado ao destruir a Activity
        currentPlayer?.release()
        currentPlayer = null
    }
}