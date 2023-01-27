package shawn.martin.babybuy.data

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    // nullable because if not logged in => null user
    val currentUser: FirebaseUser?

    suspend fun logIn(email: String, password: String): Resource<FirebaseUser>
    suspend fun signUp(email: String, password: String): Resource<FirebaseUser>
    fun logOut()
}