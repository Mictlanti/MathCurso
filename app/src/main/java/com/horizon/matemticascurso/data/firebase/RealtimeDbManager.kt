package com.horizon.matemticascurso.data.firebase

import com.google.firebase.database.FirebaseDatabase

class RealtimeDbManager(
    authManager: AuthManager
) {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val user = authManager.getCurrentUser()
    val userRef = user?.uid?.let { userId ->
        database.getReference("users").child(userId)
    }
    /* val livesRef = userRef?.child("lives")
    val expRef = userRef?.child("exp")
    val currentTimerRef = userRef?.child("timer")
    val lastUpdate = userRef?.child("lastUpdate") */

}