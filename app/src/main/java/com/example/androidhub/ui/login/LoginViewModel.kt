package com.example.androidhub.ui.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhub.model.entity.UserEntity
import com.example.androidhub.preferences.DataStoreRepository
import com.example.androidhub.repository.UserRepository
import com.example.androidhub.util.Constants.IS_LOGGED_IN
import com.example.androidhub.util.Constants.VERIFY_EMAIL
import com.example.androidhub.util.Resource
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val userRepository: UserRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _loginState = mutableStateOf(firebaseAuth.currentUser != null)
    val loginState: State<Boolean> = _loginState

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    fun setEmailText(email: String) {
        _emailText.value = email
    }

    fun setPasswordText(password: String) {
        _passwordText.value = password
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun setEmailError(error: String) {
        _emailError.value = error
    }

    fun setPasswordError(error: String) {
        _passwordError.value = error
    }

    private val _progress = mutableStateOf(false)
    val progress: State<Boolean> = _progress

    private fun setProgress(value: Boolean) {
        _progress.value = value
    }

    private val _loginMessage = mutableStateOf("")
    val loginMessage: State<String> = _loginMessage

    fun setLoginMessage(value: String) {
        _loginMessage.value = value
    }

    fun login() = viewModelScope.launch {
        setProgress(true)
        firebaseAuth.signInWithEmailAndPassword(emailText.value, passwordText.value)
            .addOnCompleteListener { login ->
                if (login.isSuccessful) {
                    firebaseAuth.currentUser!!.reload().addOnCompleteListener { reload ->
                        if (reload.isSuccessful) {
                            if (firebaseAuth.currentUser!!.isEmailVerified) {
                                saveUserInfo(currentUserId = firebaseAuth.currentUser!!.uid)
                                updateLoginState()
                                setProgress(false)
                            } else {
                                setLoginMessage(VERIFY_EMAIL)
                                setProgress(false)
                            }
                        } else {
                            setLoginMessage(reload.exception!!.message.toString())
                            setProgress(false)
                        }
                    }
                } else {
                    setLoginMessage(login.exception!!.message.toString())
                    setProgress(false)
                }
            }
    }

    private fun updateLoginState() = viewModelScope.launch {
        dataStoreRepository.putBoolean(IS_LOGGED_IN, true)
        _loginState.value = true
    }

    private fun saveUserInfo(currentUserId: String) = viewModelScope.launch {
        setProgress(true)
        when (val response = userRepository.getUserProfile(currentUserId, currentUserId)) {
            is Resource.Success -> {
                val userProfile = response.data!!.data
                val user = UserEntity(
                    userId = userProfile.userId,
                    username = userProfile.username,
                    bio = userProfile.bio,
                    profilePictureUrl = userProfile.profilePictureUrl,
                    bannerUrl = userProfile.bannerUrl,
                    topSkills = userProfile.topSkills,
                    followerCount = userProfile.followerCount,
                    followingCount = userProfile.followingCount,
                    postCount = userProfile.postCount,
                    articleCount = userProfile.articleCount,
                    gitHubUrl = userProfile.gitHubUrl,
                    linkedInUrl = userProfile.linkedInUrl
                )
                userRepository.insertUserToDB(user)
                setProgress(false)
            }
            is Resource.Error -> {
                setLoginMessage(response.message!!.toString())
                setProgress(false)
            }
            is Resource.Loading -> {

            }
        }
    }

}