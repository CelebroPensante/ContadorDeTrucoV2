package com.example.contadordetruco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Verificar se o usuário está autenticado
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser

        if (currentUser == null) {
            // Se não estiver autenticado, redirecionar para LoginActivity
            goToLoginActivity()
            return
        }

        setContentView(R.layout.activity_main)

        val btnPontuador = findViewById<Button>(R.id.btn_pontuador)
        btnPontuador.setOnClickListener {
            val intent = Intent(this, ConfiguracaoDuplasActivity::class.java)
            startActivity(intent)
        }

        val btnSorteio = findViewById<Button>(R.id.btn_sorteio)
        btnSorteio.setOnClickListener {
            val intent = Intent(this, SorteioActivity::class.java)
            startActivity(intent)
        }

        val btnEstatisticas = findViewById<Button>(R.id.btn_estatisticas)
        btnEstatisticas.setOnClickListener {
            val intent = Intent(this, EstatisticasActivity::class.java)
            startActivity(intent)
        }
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}