package com.itstack.quotesapp.Backend.FireBaseConn

import android.content.Context
import java.time.LocalDateTime
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddDataToFireBase(context: Context) {
    private val auth: FirebaseAuth
    private val database: DatabaseReference


    init {
        FirebaseApp.initializeApp(context)
        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
            .getReference("users")
    }


    internal fun addtofevorite(
        id: String,
        quote: String,
        author : String,
        onResult: (Boolean) -> Unit
    ){
        val userData = mapOf(
            "quote" to quote,
            "author" to author,
            "add_date" to LocalDateTime.now().toString()
        )
        val userId = auth.currentUser
        val uid = userId?.uid

        database.child(uid!!).child("fav_quotes").child(id).setValue(userData)
            .addOnSuccessListener {
                println("quote saved successfully!")
                onResult(true)
            }
            .addOnFailureListener { e ->
                println("Error saving quote : ${e.message}")
                onResult(false)
            }
    }
}