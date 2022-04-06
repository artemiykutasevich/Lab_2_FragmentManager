package com.example.lab_2_fragmentmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.lab_2_fragmentmanager.databinding.FragmentEditAccountBinding

class EditAccountFragment : Fragment() {
    lateinit var binding: FragmentEditAccountBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditAccountBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.firstnameEditView.setText(dataModel.firstname.value)
        binding.lastnameEditView.setText(dataModel.lastname.value)
        binding.middlenameEditView.setText(dataModel.middlename.value)
        binding.universityEditView.setText(dataModel.university.value)
        binding.facultyEditView.setText(dataModel.faculty.value)
        binding.courseEditView.setText(dataModel.course.value)

        binding.saveButton.setOnClickListener {
            saveInformation()
            dataModel.showEditFragment.value = false
        }
        binding.backButton.setOnClickListener {
            dataModel.showEditFragment.value = false
        }
    }

    private fun saveInformation() {
        dataModel.firstname.value = binding.firstnameEditView.text.toString()
        dataModel.lastname.value = binding.lastnameEditView.text.toString()
        dataModel.middlename.value = binding.middlenameEditView.text.toString()
        dataModel.university.value = binding.universityEditView.text.toString()
        dataModel.faculty.value = binding.facultyEditView.text.toString()
        dataModel.course.value = binding.courseEditView.text.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance() = EditAccountFragment()
    }
}