package com.example.contadordetruco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ConfiguracaoDuplasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracao_duplas)

        val editNomeEquipe1 = findViewById<EditText>(R.id.editNomeEquipe1)
        val editNomeEquipe2 = findViewById<EditText>(R.id.editNomeEquipe2)
        val editEmailJogador1_1 = findViewById<EditText>(R.id.editEmailJogador1_1)
        val editEmailJogador1_2 = findViewById<EditText>(R.id.editEmailJogador1_2)
        val editEmailJogador2_1 = findViewById<EditText>(R.id.editEmailJogador2_1)
        val editEmailJogador2_2 = findViewById<EditText>(R.id.editEmailJogador2_2)
        val btnIniciarJogo = findViewById<Button>(R.id.btnIniciarJogo)

        btnIniciarJogo.setOnClickListener {
            if (validarCampos()) {
                val nomeEquipe1 = editNomeEquipe1.text.toString().trim()
                val nomeEquipe2 = editNomeEquipe2.text.toString().trim()
                val emailJogador1_1 = editEmailJogador1_1.text.toString().trim()
                val emailJogador1_2 = editEmailJogador1_2.text.toString().trim()
                val emailJogador2_1 = editEmailJogador2_1.text.toString().trim()
                val emailJogador2_2 = editEmailJogador2_2.text.toString().trim()

                // Iniciar a JogoActivity com os dados das duplas
                val intent = Intent(this, JogoActivity::class.java).apply {
                    putExtra("NOME_EQUIPE1", nomeEquipe1)
                    putExtra("NOME_EQUIPE2", nomeEquipe2)
                    putExtra("EMAIL_EQUIPE1_JOGADOR1", emailJogador1_1)
                    putExtra("EMAIL_EQUIPE1_JOGADOR2", emailJogador1_2)
                    putExtra("EMAIL_EQUIPE2_JOGADOR1", emailJogador2_1)
                    putExtra("EMAIL_EQUIPE2_JOGADOR2", emailJogador2_2)
                }
                startActivity(intent)
                finish()
            }
        }
    }

    private fun validarCampos(): Boolean {
        val editNomeEquipe1 = findViewById<EditText>(R.id.editNomeEquipe1)
        val editNomeEquipe2 = findViewById<EditText>(R.id.editNomeEquipe2)
        val editEmailJogador1_1 = findViewById<EditText>(R.id.editEmailJogador1_1)
        val editEmailJogador1_2 = findViewById<EditText>(R.id.editEmailJogador1_2)
        val editEmailJogador2_1 = findViewById<EditText>(R.id.editEmailJogador2_1)
        val editEmailJogador2_2 = findViewById<EditText>(R.id.editEmailJogador2_2)

        if (editNomeEquipe1.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Digite o nome da Equipe 1", Toast.LENGTH_SHORT).show()
            return false
        }

        if (editNomeEquipe2.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Digite o nome da Equipe 2", Toast.LENGTH_SHORT).show()
            return false
        }

        if (editEmailJogador1_1.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Digite o email do primeiro jogador da Equipe 1", Toast.LENGTH_SHORT).show()
            return false
        }

        if (editEmailJogador1_2.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Digite o email do segundo jogador da Equipe 1", Toast.LENGTH_SHORT).show()
            return false
        }

        if (editEmailJogador2_1.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Digite o email do primeiro jogador da Equipe 2", Toast.LENGTH_SHORT).show()
            return false
        }

        if (editEmailJogador2_2.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Digite o email do segundo jogador da Equipe 2", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}