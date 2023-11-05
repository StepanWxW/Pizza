package com.stepan.pizza.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.stepan.pizza.R
import com.stepan.pizza.databinding.FragmentHomeBinding
import com.stepan.pizza.presentation.adapter.PizzaAdapter
import com.stepan.pizza.presentation.adapter.PromotionAdapter
import com.stepan.pizza.presentation.adapter.TitleUIAdapter
import com.stepan.pizza.presentation.model.PromotionUI
import com.stepan.pizza.presentation.model.TitleUI


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val promotionList = hardCodeAddPromotion()
        val adapterPromotion = PromotionAdapter(promotionList)
        binding.recyclerViewPromotion.adapter = adapterPromotion

        val titleList = hardCodeAddTitleUI()
        val adapterTitle = TitleUIAdapter(titleList)
        binding.recyclerViewTitle.adapter = adapterTitle

        pizzasObserve()
        exceptionObserve()

        val toolbar = requireActivity().findViewById<Toolbar>(R.id.my_toolbar)
        toolbar?.visibility = View.VISIBLE
    }

    private fun pizzasObserve() {
        viewModel.pizzas.observe(viewLifecycleOwner) {
            binding.recyclerViewPizza.adapter = PizzaAdapter(it)
            binding.loadingLayout.visibility = View.GONE
        }
    }

    private fun exceptionObserve() {
        viewModel.errorLiveData.observe(viewLifecycleOwner) { errorMessage ->
            errorMessage?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
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