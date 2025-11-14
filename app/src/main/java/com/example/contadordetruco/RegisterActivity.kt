package com.example.contadordetruco

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contadordetruco.Model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue


class RegisterActivity : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth


    private lateinit var editTextEmailRegister: EditText
    private lateinit var editTextPasswordRegister: EditText
    private lateinit var editTextConfirmPasswordRegister: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonGoToLogin: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        auth = FirebaseAuth.getInstance()


        editTextEmailRegister = findViewById(R.id.editTextEmailRegister)
        editTextPasswordRegister = findViewById(R.id.editTextPasswordRegister)
        editTextConfirmPasswordRegister = findViewById(R.id.editTextConfirmPasswordRegister)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonGoToLogin = findViewById(R.id.buttonGoToLogin)


        buttonRegister.setOnClickListener {
            performRegister()
        }


        buttonGoToLogin.setOnClickListener {
            finish()
        }
    }


    private fun performRegister() {



        val email = editTextEmailRegister.text.toString().trim()
        val password = editTextPasswordRegister.text.toString().trim()
        val confirmPassword = editTextConfirmPasswordRegister.text.toString().trim()

        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "As senhas não coincidem.", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.length < 6) {
            Toast.makeText(this, "A senha deve ter no mínimo 6 caracteres.", Toast.LENGTH_SHORT).show()
            return
        }


        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "Conta criada com sucesso! Você está logado.", Toast.LENGTH_LONG).show()
                    finish()
                } else {

                    Toast.makeText(this, "Falha no registro: ${task.exception?.message}",
                        Toast.LENGTH_LONG).show()
                }
            }
    }
}