package com.example.lab_2_fragmentmanager

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_2_fragmentmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    private lateinit var activeFragment: ActiveFragmentEnum

    val realUsername = "username"
    val realPassword = "password"

    var tmpUsername = ""
    var tmpPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(ActiveFragmentEnum.authorization)

        dataModel.firstname.value = "Artem"
        dataModel.lastname.value = "Kutasevich"
        dataModel.middlename.value = "Gennadevich"
        dataModel.university.value = "BSUIR"
        dataModel.faculty.value = "FITY"
        dataModel.course.value = "3"

        dataModel.username.observe(this, {
            tmpUsername = it
            authorization()
        })

        dataModel.password.observe(this, {
            tmpPassword = it
            authorization()
        })

        dataModel.showEditFragment.observe(this, {
            if (it == true) {
                openFrag(ActiveFragmentEnum.editAccount)
            }
            if (it == false) {
                openFrag(ActiveFragmentEnum.account)
            }
        })
    }

    override fun onBackPressed() {
        if (activeFragment == ActiveFragmentEnum.editAccount) {
            println("я дошёл")
            openFrag(ActiveFragmentEnum.account)
        } else {
            super.onBackPressed()
        }
    }

    private fun authorization() {
        if ((tmpUsername == realUsername) && (tmpPassword == realPassword)) {
            openFrag(ActiveFragmentEnum.account)
        } else {
            val text = "Something bad"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }

    private fun openFrag(f: ActiveFragmentEnum) {
        activeFragment = f
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.place_holder, f.fragment)
            .commit()
    }
}