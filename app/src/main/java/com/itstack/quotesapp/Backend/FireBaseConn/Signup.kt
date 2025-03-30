package com.itstack.quotesapp.Backend.FireBaseConn
import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

    class Signup(context: Context) {
        private val auth: FirebaseAuth
        private val database: DatabaseReference


        init {
            FirebaseApp.initializeApp(context)  // Ensure Firebase is initialized
            auth = FirebaseAuth.getInstance()

            database = FirebaseDatabase.getInstance()
                .getReference("users")
        }

        fun signupUser(email: String, password: String) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        if (user != null) {
                            saveUserToDatabase(user.uid, email)
                        }
                        println("User Registered: ${user?.email}")
                    } else {
                        println("Error: ${task.exception?.message}")
                    }
                }
        }

        private fun saveUserToDatabase(userId: String, email: String) {
            val userData = mapOf(
                "email" to email
            )

            database.child(userId).child("profile_data").setValue(userData)
                .addOnSuccessListener {
                    println("User data saved successfully!")
                }
                .addOnFailureListener { e ->
                    println("Error saving user data: ${e.message}")
                }
        }

}