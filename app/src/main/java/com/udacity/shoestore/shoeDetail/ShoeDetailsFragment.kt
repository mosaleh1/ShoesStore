package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.MainActivityViewModelFactory


class ShoeDetailsFragment : Fragment(R.layout.fragment_shoe_details) {

    private lateinit var shoeViewModel: MainActivityViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentShoeDetailsBinding.bind(view)

        shoeViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

        binding.shoe = Shoe("", 0.0, "", "")
        binding.actionSaveBtnShoeDetail.setOnClickListener {
            val company = binding.companyShoeDetailsField.text.toString()
            val name = binding.nameShoeDetailsField.text.toString()
            val size = binding.shoeSizeShoeDetailsField.text.toString()
            val description = binding.descriptionShoeDetailsField.text.toString()

            if (dataValid(name, company, size, description)) {
                val verifySize = try {
                    size.toDouble()
                } catch (e: Exception) {
                    0.0
                }
                if (verifySize == 0.0) {
                    Toast.makeText(
                        requireContext(),
                        "Please enter a valid size",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

                shoeViewModel.add(Shoe(name, size.toDouble(), company, description))
                Toast.makeText(context, "shoe added successfully", Toast.LENGTH_LONG)
                    .show()
                findNavController().navigateUp()
            }
        }

        binding.actionCancelBtnShoeDetail.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun navigateToListFragment() {
        val action =
            ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment()
        findNavController().navigate(action)
    }

    private fun dataValid(
        name: String,
        company: String,
        size: String,
        description: String
    ): Boolean {
        val bool = try {
            size.toDouble()
            true
        } catch (e: Exception) {
            return false
        }

        if (!bool)
            Toast.makeText(
                requireContext(),
                "plase fill the size correctly", Toast.LENGTH_SHORT
            ).show()

        return bool && name.trim().isNotEmpty() &&
                company.trim().isNotEmpty() &&
                size.trim().isNotEmpty() &&
                description.trim().isNotEmpty()
    }
}