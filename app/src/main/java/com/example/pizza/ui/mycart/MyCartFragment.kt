package com.example.pizza.ui.mycart


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizza.SubApplication
import com.example.pizza.databinding.FragmentMyCartBinding
import com.example.pizza.retrofit.RetrofitServices
import javax.inject.Inject

class MyCartFragment : Fragment() {
    private lateinit var binding: FragmentMyCartBinding
    private lateinit var adapterMyCart: MyCartAdapter
    private lateinit var myCartViewModel: MyCartViewModel

    @Inject
    lateinit var retrofitServices: RetrofitServices

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMyCartBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appComponent = (requireContext().applicationContext as SubApplication).appComponent
        appComponent.getMyCartComponent().injectMyCartFragment(this)
        val dataNetworkInteract = DataNetworkMyCartInteract(retrofitServices)
        val viewModelFactory = MyCartViewModelFactory(dataNetworkInteract)
        myCartViewModel =
            ViewModelProvider(this, viewModelFactory)[MyCartViewModel::class.java]
        adapterMyCart = MyCartAdapter()
        myCartViewModel.onViewCreatedLoadingProductDetails()
        binding.recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView1.adapter = adapterMyCart
        initObserves()
    }

    private fun initObserves() {
        myCartViewModel.loadingProductDetails.observe(requireActivity()) {
            binding.deliveryFree.text = it.delivery
            binding.priceTotal.text = it.total
        }
        myCartViewModel.loadingImages.observe(requireActivity()) {
            adapterMyCart.setDataMyCart(it)
        }
    }
}




