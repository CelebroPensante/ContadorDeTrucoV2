package com.example.contadordetruco

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    private lateinit var editTextEmailLogin: EditText
    private lateinit var editTextPasswordLogin: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonGoToRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()


        editTextEmailLogin = findViewById(R.id.editTextEmailLogin)
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonGoToRegister = findViewById(R.id.buttonGoToRegister)


        buttonLogin.setOnClickListener {
            performLogin()
        }


        buttonGoToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null) {
            goToMainActivity()
        }
    }


    private fun performLogin() {
        val email = editTextEmailLogin.text.toString().trim()
        val password = editTextPasswordLogin.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            return
        }


        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val user = auth.currentUser
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    goToMainActivity()
                } else {

                    Toast.makeText(this, "Falha na autenticação: ${task.exception?.message}",
                        Toast.LENGTH_LONG).show()
                }
            }
    }

    /**
     * Redireciona para a tela principal e encerra a Activity de Login.
     */
    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}