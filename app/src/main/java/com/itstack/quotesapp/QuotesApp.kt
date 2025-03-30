package com.itstack.quotesapp

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp

class QuotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)

        if (FirebaseApp.getApps(this).isEmpty()) {
            Log.e("Firebase", "FirebaseApp initialization failed!")
        } else {
            Log.d("Firebase", "FirebaseApp initialized successfully!")
        }
    }
}
