package com.udacity.shoestore.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.MainActivityViewModel


class ShoeDetailsFragment : Fragment() {

    private val shoeViewModel by activityViewModels<MainActivityViewModel>()
    private var _binding: FragmentShoeDetailsBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeDetailsBinding.inflate(layoutInflater)

        return binding.root
    }

    var _shoe: Shoe? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            shoe = Shoe("", 2.0, "", "")
            binding.actionSaveBtnShoeDetail.setOnClickListener {
                val name = binding.shoe?.name ?: ""
                val company = binding.shoe?.company ?: ""
                val size = binding.shoe?.size.toString()
                val description = binding.shoe?.description ?: ""

                if (name.isEmpty()) {
                    Toast.makeText(context, "name is empty", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }

                if (company.isEmpty()) {
                    Toast.makeText(
                        context,
                        "company name is empty",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }

                if (size.isEmpty()) {
                    Toast.makeText(context, "size not valid or empty", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }

                if (description.isEmpty()) {
                    Toast.makeText(
                        context,
                        "description is empty",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    return@setOnClickListener
                }
                shoeViewModel.add(Shoe(name, size.toDouble(), company, description))
                Toast.makeText(context, "shoe added successfully", Toast.LENGTH_LONG)
                    .show()
                findNavController().navigateUp()
            }

            binding.actionCancelBtnShoeDetail.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}