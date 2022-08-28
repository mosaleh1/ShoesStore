package com.udacity.shoestore.Instractions

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstractionsBinding
import com.udacity.shoestore.models.Shoe

class InstructionsFragment : Fragment(R.layout.fragment_instractions) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mBinding = FragmentInstractionsBinding.bind(view)

        mBinding.nextInstraction.setOnClickListener {
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
            val action = InstructionsFragmentDirections.
            actionInstructionsFragmentToShoeListFragment()
            findNavController().navigate(action)
        }
    }


}