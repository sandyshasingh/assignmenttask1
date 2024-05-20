package com.example.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailField:EditText
    private lateinit var passwordField:EditText
    private lateinit var signUpButton:Button
    private lateinit var signInButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        auth = FirebaseAuth.getInstance()
        emailField = findViewById(R.id.email)
        passwordField = findViewById(R.id.password)
        signUpButton = findViewById(R.id.signUp)
        signInButton = findViewById(R.id.signIn)

        signUpButton.setOnClickListener{ signUp()}
        signInButton.setOnClickListener { signIn() }


    }

    private fun signIn() {
        val email= emailField.text.toString()
        val password = passwordField.text.toString()
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(baseContext, "Sign In failed.", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun signUp(){
        val email = emailField.text.toString()
        val password = passwordField.text.toString()
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful){
                    val user = auth.currentUser
                    user?.let {
                        writeNewUser(it.uid,it.email ?: "")
                    }
                    startActivity(Intent(this, MainActivity::class.java))

                finish()
                }else{
                    Toast.makeText(baseContext, "sign Up failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun writeNewUser(userId: String, email: String) {
        val user = User(email)
        FirebaseDatabase.getInstance().getReference("users").child(userId).setValue(user)

    }
    data class User(val email: String)
}