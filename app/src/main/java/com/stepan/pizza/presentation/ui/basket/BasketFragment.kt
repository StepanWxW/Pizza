package com.stepan.pizza.presentation.ui.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stepan.pizza.R
import com.stepan.pizza.databinding.FragmentBasketBinding

class BasketFragment : Fragment() {

    private var _binding: FragmentBasketBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val basketViewModel =
            ViewModelProvider(this).get(BasketViewModel::class.java)

        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBasket
        basketViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val toolbar = requireActivity().findViewById<Toolbar>(R.id.my_toolbar)
        toolbar.visibility = View.GONE
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}