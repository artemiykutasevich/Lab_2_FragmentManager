package com.example.lab_2_fragmentmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.lab_2_fragmentmanager.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {
    lateinit var binding: FragmentAccountBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.firstnameTextView.text = dataModel.firstname.value
        binding.lastnameTextView.text = dataModel.lastname.value
        binding.middlenameTextView.text = dataModel.middlename.value
        binding.universityTextView.text = dataModel.university.value
        binding.facultyTextView.text = dataModel.faculty.value
        binding.courseTextView.text = dataModel.course.value.toString()

        binding.editProfileButton.setOnClickListener {
            dataModel.showEditFragment.value = true
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragment()
    }
}