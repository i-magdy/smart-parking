package com.devwarex.smartparking

import android.util.Log
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.asDeferred
import kotlinx.coroutines.withContext

data class US(val name: String)
class AndroidCurrentUser : CurrentUser{

    private val db = Firebase.firestore
    private val coroutine = CoroutineScope(Dispatchers.IO)

    override fun isUserLogged(): Boolean {
        Log.e("smart_user",Firebase.auth.currentUser?.uid ?: "null")
        return Firebase.auth.currentUser != null
    }

    override suspend fun isUserSignedUp(): Boolean = withContext(coroutine.coroutineContext) {
        return@withContext db.collection("users").document(Firebase.auth.currentUser?.uid ?: "id")
            .get(Source.SERVER).addOnCompleteListener { Log.e("smart_user",it.result.exists().toString())  }.asDeferred().await().exists()
    }

    override suspend fun signupUser(name: String): Boolean = withContext(coroutine.coroutineContext){
        val map = mutableMapOf<String,String>()
        map["name"] = name
        Log.e("smart_user",map.toMap().toString())
        return@withContext db.collection("users")
            .document(Firebase.auth.currentUser?.uid ?: "id")
            .set(map.toMap()).addOnCompleteListener{}.asDeferred().isCancelled
    }
}

actual fun getCurrentUser(): CurrentUser = AndroidCurrentUser()