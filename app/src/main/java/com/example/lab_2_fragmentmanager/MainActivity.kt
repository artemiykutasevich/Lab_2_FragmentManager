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

    var tmpUsername = ""
    var tmpPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(AuthorizationFragment.newInstance())

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
                openFrag(EditAccountFragment.newInstance())
            }
            if (it == false) {
                openFrag(AccountFragment.newInstance())
            }
        })
    }

    private fun authorization() {
        if ((tmpUsername == realUsername) && (tmpPassword == realPassword)) {
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