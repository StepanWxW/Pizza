package com.stepan.pizza.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stepan.pizza.databinding.FragmentHomeBinding
import com.stepan.pizza.presentation.adapter.PromotionAdapter
import com.stepan.pizza.presentation.model.PromotionModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
//
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val promotionList = hardCodeAddPromotion()
        val adapter = PromotionAdapter(promotionList)
        binding.recyclerViewPromotion.adapter = adapter
    }

    private fun hardCodeAddPromotion(): List<PromotionModel> {
        return listOf(
            PromotionModel("https://pizzayoli.ru/image/cache/catalog/stocks/one_one-1000x0.jpg"),
            PromotionModel("https://cdpiz1.pizzasoft.ru/pizzafab/content/2/2377/image_5cc2ffaf27693.jpg"),
            PromotionModel("https://www.givetwo.ru/images/slider/15.jpg"),
            PromotionModel("https://www.givetwo.ru/images/slider/12.jpg"),
            PromotionModel("https://www.givetwo.ru/images/slider/14.jpg")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}