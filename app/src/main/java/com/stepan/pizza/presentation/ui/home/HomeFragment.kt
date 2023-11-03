package com.stepan.pizza.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stepan.pizza.R
import com.stepan.pizza.databinding.FragmentHomeBinding
import com.stepan.pizza.presentation.adapter.PromotionAdapter
import com.stepan.pizza.presentation.adapter.TitleUIAdapter
import com.stepan.pizza.presentation.model.PromotionUI
import com.stepan.pizza.presentation.model.TitleUI


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

//        val toolbar = activity?.findViewById<Toolbar>(R.id.my_toolbar)
//        val yourData: List<String> = listOf("Москва", "Санкт-Петербург", "Новосибирск")
//        toolbar?.let {
//            val spinner = it.findViewById<Spinner>(R.id.spinnerCity)
//            spinner?.let {
//                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, yourData)
//                it.adapter = adapter
//            }
//        }

        val promotionList = hardCodeAddPromotion()
        val adapterPromotion = PromotionAdapter(promotionList)
        binding.recyclerViewPromotion.adapter = adapterPromotion

        val titleList = hardCodeAddTitleUI()
        val adapterTitle = TitleUIAdapter(titleList)
        binding.recyclerViewTitle.adapter = adapterTitle
    }

    private fun hardCodeAddPromotion(): List<PromotionUI> {
        return listOf(
            PromotionUI("https://pizzayoli.ru/image/cache/catalog/stocks/one_one-1000x0.jpg"),
            PromotionUI("https://cdpiz1.pizzasoft.ru/pizzafab/content/2/2377/image_5cc2ffaf27693.jpg"),
            PromotionUI("https://www.givetwo.ru/images/slider/15.jpg"),
            PromotionUI("https://www.givetwo.ru/images/slider/12.jpg"),
            PromotionUI("https://www.givetwo.ru/images/slider/14.jpg")
        )
    }

    private fun hardCodeAddTitleUI(): List<TitleUI> {
        return listOf(
            TitleUI("Пицца", true),
            TitleUI("Комбо", false),
            TitleUI("Десерты", false),
            TitleUI("Напитки", false)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}