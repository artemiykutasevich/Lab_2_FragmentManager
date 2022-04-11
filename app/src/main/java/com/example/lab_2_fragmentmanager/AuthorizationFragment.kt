package com.example.lab_2_fragmentmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.lab_2_fragmentmanager.databinding.ActivityMainBinding
import com.example.lab_2_fragmentmanager.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {
    lateinit var binding: FragmentAuthorizationBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorizationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.signInButton.setOnClickListener {
            dataModel.username.value = binding.usernameTextField.text.toString()
            //println(binding.usernameTextField.text.toString())
            dataModel.password.value = binding.passwordTextField.text.toString()
            //println(binding.passwordTextField.text.toString())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AuthorizationFragment()
    }
}