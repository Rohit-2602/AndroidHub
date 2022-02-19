package com.example.androidhub.ui.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhub.repository.AuthRepository
import com.example.androidhub.util.Constants.USERNAME_ALREADY_EXIST
import com.example.androidhub.util.Constants.USER_ALREADY_EXIST
import com.example.androidhub.util.Resource
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _userNameText = mutableStateOf("")
    val userNameText: State<String> = _userNameText

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _confirmPasswordText = mutableStateOf("")
    val confirmPasswordText: State<String> = _confirmPasswordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _showConfirmPassword = mutableStateOf(false)
    val showConfirmPassword: State<Boolean> = _showConfirmPassword

    private val _userNameError = mutableStateOf("")
    val userNameError: State<String> = _userNameError

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    private val _confirmPasswordError = mutableStateOf("")
    val confirmPasswordError: State<String> = _confirmPasswordError

    fun setUserNameText(userName: String) {
        _userNameText.value = userName
    }

    fun setEmailText(email: String) {
        _emailText.value = email
    }

    fun setPasswordText(password: String) {
        _passwordText.value = password
    }

    fun setConfirmPasswordText(password: String) {
        _confirmPasswordText.value = password
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun setShowConfirmPassword(showPassword: Boolean) {
        _showConfirmPassword.value = showPassword
    }

    fun setUserNameError(error: String) {
        _userNameError.value = error
    }

    fun setEmailError(error: String) {
        _emailError.value = error
    }

    fun setPasswordError(error: String) {
        _passwordError.value = error
    }

    fun setConfirmPasswordError(error: String) {
        _confirmPasswordError.value = error
    }

    private val _progress = mutableStateOf(false)
    val progress: State<Boolean> = _progress

    private fun setProgress(value: Boolean) {
        _progress.value = value
    }

    private val _signUpMessage = mutableStateOf("")
    val signUpMessage: State<String> = _signUpMessage

    fun setSignUpMessage(value: String) {
        _signUpMessage.value = value
    }

    fun createUser(onSuccess: () -> Unit) = viewModelScope.launch {
        setProgress(true)
        when(val response = authRepository.verifyFields(username = userNameText.value, email = emailText.value)) {
            is Resource.Loading -> {

            }
            is Resource.Success -> {
                if (response.data!!.successful) {
                    firebaseAuth.createUserWithEmailAndPassword(emailText.value, passwordText.value)
                        .addOnCompleteListener { authResult ->
                            if (authResult.isSuccessful) {
                                firebaseAuth.currentUser!!.sendEmailVerification()
                                    .addOnCompleteListener { emailVerification ->
                                        if (emailVerification.isSuccessful) {
                                            createUser(id = firebaseAuth.currentUser!!.uid)
                                            setProgress(false)
                                            onSuccess()
                                        } else {
                                            setProgress(false)
                                            setSignUpMessage(emailVerification.exception!!.message.toString())
                                        }
                                    }
                            } else {
                                setProgress(false)
                                setSignUpMessage(authResult.exception!!.message.toString())
                            }
                        }
                } else {
                    if (response.data.message == USERNAME_ALREADY_EXIST) {
                        setUserNameError(USERNAME_ALREADY_EXIST)
                    }
                    if (response.data.message == USER_ALREADY_EXIST) {
                        setEmailError(USER_ALREADY_EXIST)
                    }
                    setProgress(false)
                }
            }
            is Resource.Error -> {
                setSignUpMessage(response.message.toString())
                setProgress(false)
            }
        }
    }

    private fun createUser(id: String) = viewModelScope.launch {
        when(val response = authRepository.createUser(id, email = emailText.value, username = userNameText.value)) {
            is Resource.Success -> {
                setProgress(false)
            }
            is Resource.Error -> {
                setSignUpMessage(response.message.toString())
                setProgress(false)
            }
            is Resource.Loading -> {

            }
        }
    }

}