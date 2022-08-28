package com.udacity.shoestore.LoginScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var mBinding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = FragmentLoginBinding.bind(view)

        mBinding.loginAgainBtn.setOnClickListener {

        }
        mBinding.loginNewBtn.setOnClickListener {
            navigateToWelcome()
        }
    }

    private fun navigateToWelcome() {
        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}