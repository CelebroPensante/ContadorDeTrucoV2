package com.example.contadordetruco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import com.google.firebase.Firebase
import com.google.firebase.database.database

class SorteioActivity : AppCompatActivity() {

    // Declaração das variáveis dos componentes (usando lateinit para inicializar depois)
    private lateinit var editTextNome1: EditText
    private lateinit var editTextNome2: EditText
    private lateinit var editTextNome3: EditText
    private lateinit var editTextNome4: EditText
    private lateinit var buttonSortear: Button
    private lateinit var textViewSorteado1: TextView
    private lateinit var textViewSorteado2: TextView

    // NOVO: Variável para o botão de voltar
    private lateinit var btnVoltarParaMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorteio)

        editTextNome1 = findViewById(R.id.editTextNome1)
        editTextNome2 = findViewById(R.id.editTextNome2)
        editTextNome3 = findViewById(R.id.editTextNome3)
        editTextNome4 = findViewById(R.id.editTextNome4)
        buttonSortear = findViewById(R.id.buttonSortear)
        textViewSorteado1 = findViewById(R.id.textViewSorteado1)
        textViewSorteado2 = findViewById(R.id.textViewSorteado2)

        btnVoltarParaMain = findViewById(R.id.btnVoltarParaMain)

        buttonSortear.setOnClickListener {
            realizarSorteio()
        }

        btnVoltarParaMain.setOnClickListener {
            finish()
        }
    }

    private fun realizarSorteio() {
        val nomesDigitados = listOf(
            editTextNome1.text.toString().trim(),
            editTextNome2.text.toString().trim(),
            editTextNome3.text.toString().trim(),
            editTextNome4.text.toString().trim()
        )

        val listaDeNomesValidos = nomesDigitados
            .filter { it.isNotEmpty() }
            .map { it.replaceFirstChar { char -> if (char.isLowerCase()) char.titlecase() else char.toString() } }

        if (listaDeNomesValidos.size < 2) {
            Toast.makeText(this, "Por favor, digite pelo menos 2 nomes válidos para sortear.", Toast.LENGTH_LONG).show()
            textViewSorteado1.text = "-"
            textViewSorteado2.text = "-"
            return
        }

        val listaEmbaralhada = listaDeNomesValidos.shuffled()
        val sorteados = listaEmbaralhada.take(2)

        textViewSorteado1.text = sorteados[0]
        textViewSorteado2.text = sorteados[1]

        Toast.makeText(this, "Sorteio realizado com sucesso!", Toast.LENGTH_SHORT).show()

    }

}