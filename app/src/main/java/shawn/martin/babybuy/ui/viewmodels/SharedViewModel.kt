package shawn.martin.babybuy.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import shawn.martin.babybuy.data.AuthRepository
import shawn.martin.babybuy.data.Resource
import javax.inject.Inject

@HiltViewModel
// Classed used to handle all business and API logic
class SharedViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _logInFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Resource<FirebaseUser>?> = _logInFlow

    private val _signUpFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signUpFlow: StateFlow<Resource<FirebaseUser>?> = _signUpFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if (repository.currentUser != null) {
            _logInFlow.value = Resource.Success(repository.currentUser!!)
        }
    }

    fun logIn(email: String, password: String) = viewModelScope.launch {
        // Mark as Loading
        _logInFlow.value = Resource.Loading

        val result = repository.logIn(email, password)
        _logInFlow.value = result
    }

    fun signUp(email: String, password: String) = viewModelScope.launch {
        // Mark as Loading
        _signUpFlow.value = Resource.Loading

        val result = repository.signUp(email, password)
        _signUpFlow.value = result
    }

    fun logOut() {
        repository.logOut()
        _logInFlow.value = null
        _signUpFlow.value = null
    }

}