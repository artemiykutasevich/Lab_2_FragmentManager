package com.example.lab_2_fragmentmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.lab_2_fragmentmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    val realUsername = "username"
    val realPassword = "password"

    var localUsername = ""
    var localPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(AuthorizationFragment.newInstance())

        dataModel.username.observe(this, {
            localUsername = it
            authorization()
        })

        dataModel.password.observe(this, {
            localPassword = it
            authorization()
        })
    }

    private fun authorization() {
        if ((localUsername == realUsername) && (localPassword == realPassword)) {
            openFrag(AccountFragment.newInstance())
        } else {
            val text = "Something bad"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }

    private fun openFrag(f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, f)
            .commit()
    }
}