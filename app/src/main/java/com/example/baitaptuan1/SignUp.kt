package com.example.baitaptuan1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import android.widget.Toast

import com.example.baitaptuan1.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    private lateinit var bindingSignUp: ActivitySignUpBinding
    lateinit var loginViewModel: LoginViewModel
    lateinit var context: Context
    lateinit var email: String
    lateinit var password: String
    lateinit var fullname: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        bindingSignUp = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)


        context = this@SignUp

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        bindingSignUp.btLogin.setOnClickListener {
            email = bindingSignUp.etEmailSignUp.text.toString().trim()
            password = bindingSignUp.etPasswordSignup.text.toString().trim()
            fullname = bindingSignUp.etFullNameSignUp.text.toString().trim()

            if (fullname.isEmpty()) {
                bindingSignUp.etFullNameSignUp.error = "Please enter the fullname"
            } else if (email.isEmpty()) {
                bindingSignUp.etEmailSignUp.error = "Please enter the email"
            } else if (password.isEmpty()) {
                bindingSignUp.etPasswordSignup.error = "Please enter the password"
            } else {
                loginViewModel.insertData(context, email, password, fullname)
                Toast.makeText(this, "Login complete", Toast.LENGTH_LONG).show()
//                   val intent = Intent(this,Login::class.java)
//                   startActivity(intent)
            }

        }



        bindingSignUp.tvSignInSignUp.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }
}