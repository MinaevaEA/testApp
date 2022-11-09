package com.example.pizza.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pizza.SubApplication
import com.example.pizza.databinding.FragmentProductDetailsBinding
import com.example.pizza.retrofit.RetrofitServices
import retrofit2.create

class ProductDetailsFragment : Fragment() {

    private lateinit var productDetailsViewModel: ProductDetailsViewModel
    private lateinit var binding: FragmentProductDetailsBinding
    private lateinit var retrofitServices: RetrofitServices
    private lateinit var viewPagerAdapterProductDetails: ViewPagerAdapterProductDetails

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentProductDetailsBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPagerAdapterProductDetails = ViewPagerAdapterProductDetails()
        retrofitServices =
            (requireContext().applicationContext as SubApplication).provideDataFromNetwork()
                .create()

        val dataNetworkInteract = DataNetworkDetailsInteract(retrofitServices)
        val viewModelFactory = ProductDetailsViewModelFactory(dataNetworkInteract)
        productDetailsViewModel =
            ViewModelProvider(this, viewModelFactory)[ProductDetailsViewModel::class.java]
        productDetailsViewModel.onViewCreatedLoadingProductDetails()
        productDetailsViewModel.loadingProductDetails.observe(requireActivity()){
            binding.title.text = it.title
           // binding.title.text = it.title
           /* binding.camera.text = it.camera
            binding.capacity.text = it.capacity
            binding.color.text = it.color
            binding.is_Favorite.text = it.is_Favorite
            binding.rating.text = it.rating
            binding.price.text = it.price
            binding.sd.text = it.sd
            binding.ssd.text = it.ssd*/
           // Glide.with(binding.root.context).load(it.images).into(binding.image)

        }
        binding.viewPagerDetails.adapter = viewPagerAdapterProductDetails
        productDetailsViewModel.loadingImages.observe(requireActivity()) {
            viewPagerAdapterProductDetails.setDataProductDetails(it)
        }

    }
    companion object {
        fun newInstance(CPU: String): ProductDetailsFragment = ProductDetailsFragment()
    }

}