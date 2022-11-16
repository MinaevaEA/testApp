package com.example.pizza.ui.product

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pizza.R
import com.example.pizza.SubApplication
import com.example.pizza.databinding.FragmentProductDetailsBinding
import com.example.pizza.retrofit.RetrofitServices
import javax.inject.Inject
import kotlin.math.absoluteValue

class ProductDetailsFragment : Fragment() {

    private lateinit var productDetailsViewModel: ProductDetailsViewModel
    private lateinit var binding: FragmentProductDetailsBinding
    private lateinit var viewPagerAdapterProductDetails: ProductDetailsAdapter

    @Inject
    lateinit var retrofitServices: RetrofitServices
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProductDetailsBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    @SuppressLint("ResourceAsColor", "UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPagerAdapterProductDetails = ProductDetailsAdapter()
        val appComponent = (requireContext().applicationContext as SubApplication).appComponent
        appComponent.getProductDetailsComponent().injectProductDetailsComponent(this)
        val dataNetworkInteract = DataNetworkDetailsInteract(retrofitServices)
        val viewModelFactory = ProductDetailsViewModelFactory(dataNetworkInteract)
        productDetailsViewModel =
            ViewModelProvider(this, viewModelFactory)[ProductDetailsViewModel::class.java]
        productDetailsViewModel.onViewCreatedLoadingProductDetails()
        productDetailsViewModel.loadingProductDetails.observe(requireActivity()) { it ->
            binding.title.text = it.title
            binding.cpu.text = it.CPU
            binding.camera.text = it.camera
            binding.capacity.text = it.capacity[0]
            binding.sd.text = it.sd

        }
        binding.backBtn.setOnClickListener {
            productDetailsViewModel.backToMain.observe(requireActivity()) {
                backToMain()
            }
        }
        binding.viewPagerDetails.adapter = viewPagerAdapterProductDetails
        productDetailsViewModel.loadingImages.observe(requireActivity()) {
            viewPagerAdapterProductDetails.setDataProductDetails(it)
        }
    }


    private fun backToMain() {
        findNavController().navigate(R.id.navigation_home)
        /*  requireActivity().supportFragmentManager.beginTransaction()
              .addToBackStack(null)
              .replace(R.id.container, ProductDetailsFragment.newInstance(CPU))
              .commit()*/
    }
}