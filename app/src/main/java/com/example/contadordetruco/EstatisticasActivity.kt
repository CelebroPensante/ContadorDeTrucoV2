package com.example.contadordetruco

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.Locale

class EstatisticasActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estatisticas)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference.child("partidas")

        val currentUser = auth.currentUser
        if (currentUser == null) {
            // Se não houver usuário logado, fecha a tela para evitar erros.
            finish()
            return
        }

        val emailUsuario = currentUser.email ?: ""
        findViewById<TextView>(R.id.tvEmailUsuario).text = emailUsuario

        buscarEstatisticas(emailUsuario)
    }

    private fun buscarEstatisticas(emailUsuario: String) {
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (!snapshot.exists()) {
                    // Não há partidas no banco de dados
                    return
                }

                var totalPartidas = 0
                var vitoriasGerais = 0
                val estatisticasDuplas = mutableMapOf<String, Pair<Int, Int>>() // Email do parceiro -> (vitórias, total)

                for (partidaSnapshot in snapshot.children) {
                    val equipe1Jogadores = partidaSnapshot.child("equipe1/jogadores").children.mapNotNull { it.child("email").getValue(String::class.java) }
                    val equipe2Jogadores = partidaSnapshot.child("equipe2/jogadores").children.mapNotNull { it.child("email").getValue(String::class.java) }
                    val equipeVencedora = partidaSnapshot.child("equipeVencedora").getValue(String::class.java)

                    val (minhaEquipe, minhaEquipeNome) = when {
                        equipe1Jogadores.contains(emailUsuario) -> equipe1Jogadores to "Equipe 1"
                        equipe2Jogadores.contains(emailUsuario) -> equipe2Jogadores to "Equipe 2"
                        else -> continue // Usuário não participou desta partida
                    }

                    totalPartidas++
                    val parceiro = minhaEquipe.firstOrNull { it != emailUsuario && it.isNotBlank() } ?: "Sozinho"
                    val (vitorias, total) = estatisticasDuplas.getOrDefault(parceiro, 0 to 0)

                    if (equipeVencedora == minhaEquipeNome) {
                        vitoriasGerais++
                        estatisticasDuplas[parceiro] = (vitorias + 1) to (total + 1)
                    } else {
                        estatisticasDuplas[parceiro] = vitorias to (total + 1)
                    }
                }

                exibirEstatisticasGerais(vitoriasGerais, totalPartidas)
                exibirEstatisticasDuplas(estatisticasDuplas)
            }

            override fun onCancelled(error: DatabaseError) {
                // Tratar erro de banco de dados, talvez com uma mensagem para o usuário.
                // Por enquanto, apenas logamos o erro.
                println("Erro ao buscar estatísticas: ${error.message}")
            }
        })
    }

    private fun exibirEstatisticasGerais(vitorias: Int, total: Int) {
        val tvVitoriasGerais = findViewById<TextView>(R.id.tvVitoriasGerais)
        val porcentagem = if (total > 0) (vitorias.toDouble() / total * 100) else 0.0
        tvVitoriasGerais.text = String.format(Locale.getDefault(), "Vitórias Gerais: %.1f%% (%d/%d)", porcentagem, vitorias, total)
    }

    private fun exibirEstatisticasDuplas(estatisticas: Map<String, Pair<Int, Int>>) {
        val llEstatisticasDuplas = findViewById<LinearLayout>(R.id.llEstatisticasDuplas)
        llEstatisticasDuplas.removeAllViews()

        for ((parceiro, stats) in estatisticas) {
            val (vitorias, total) = stats
            val porcentagem = if (total > 0) (vitorias.toDouble() / total * 100) else 0.0

            val tvDupla = TextView(this).apply {
                text = String.format(Locale.getDefault(), "Com %s: %.1f%% (%d/%d)", parceiro, porcentagem, vitorias, total)
                textSize = 16f
                setTextColor(ContextCompat.getColor(this@EstatisticasActivity, android.R.color.white))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = 8
                }
            }
            llEstatisticasDuplas.addView(tvDupla)
        }
    }
}