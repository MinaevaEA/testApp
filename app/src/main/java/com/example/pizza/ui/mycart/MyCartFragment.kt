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
import retrofit2.create

class MyCartFragment : Fragment() {
    private lateinit var binding: FragmentMyCartBinding
    private lateinit var adapterMyCart: AdapterMyCart
    private lateinit var retrofitServices: RetrofitServices
    private lateinit var myCartViewModel: MyCartViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMyCartBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrofitServices =
            (requireContext().applicationContext as SubApplication).provideDataFromNetwork()
                .create()
        val dataNetworkInteract = DataNetworkMyCartInteract(retrofitServices)
        val viewModelFactory = MyCartViewModelFactory(dataNetworkInteract)
        myCartViewModel =
            ViewModelProvider(this, viewModelFactory)[MyCartViewModel::class.java]
      //  adapterMyCart = AdapterMyCart()
        myCartViewModel.onViewCreatedLoadingProductDetails()
      //  binding.recyclerView1.layoutManager = LinearLayoutManager(requireContext())
      //  binding.recyclerView1.adapter = adapterMyCart
        // initObserves()
        myCartViewModel.loadingProductDetails.observe(requireActivity()) {
            binding.textView2.text = it.delivery
        }
    }
}
    //TODO apply with

   /* private fun initObserves() {
        myCartViewModel.loadingListCategory.observe(requireActivity()) {
            adapterCategory.setDataCategory(it)
        }
        myCartViewModel.loadingListBestSeller.observe(requireActivity()) {
            adapterMyCart.setDataBestSeller(it)
        }
        myCartViewModel.loadingHomeStore.observe(requireActivity()) {
            viewPagerAdapterHomeStore.setDataHomeStore(it)
        }*/





