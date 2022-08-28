package com.udacity.shoestore.shoeList

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.MainActivityViewModelFactory
import com.udacity.shoestore.MainActivityViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListFragment : Fragment(R.layout.fragment_shoe_list) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeViewModel: MainActivityViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShoeListBinding.bind(view)

        shoeViewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)


        shoeViewModel.shoeListLiveData.observe(viewLifecycleOwner) { shoes ->
            Timber.d("onViewCreated: Got some data ${shoes.size}")
            shoes.forEach { shoe ->
                showShoesInList(shoe)
            }
        }
        binding.nextDetail.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }

    }

    private fun showShoesInList(shoe: Shoe) {
        Timber.d("Shoe list called ${shoe.name}\n\n${shoe.description}\n\n${shoe.size}")
        val myText = TextView(requireContext())
            .apply {
                text = "\n${shoe.name}\n\n${shoe.description}\n\n${shoe.size}\n"
                setOnClickListener {

                }
            }
        myText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val divider = View(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                20
            )
        }
        divider.setBackgroundColor(Color.BLACK)
        binding.shoeListLinearlayout.addView(myText)
        binding.shoeListLinearlayout.addView(divider)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

    }
}