package com.example.pizza.mycart.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizza.R
import com.example.pizza.SubApplication
import com.example.pizza.databinding.FragmentMyCartBinding
import com.example.pizza.retrofit.RetrofitServices
import com.example.pizza.mycart.interactor.MyCartInteractorImpl
import com.example.pizza.mycart.ui.adapterlist.MyCartAdapter
import com.example.pizza.mycart.vm.MyCartViewModelImpl
import com.example.pizza.mycart.vm.MyCartViewModelFactory
import javax.inject.Inject

class MyCartFragment : Fragment() {
    private lateinit var binding: FragmentMyCartBinding
    private lateinit var adapterMyCart: MyCartAdapter
    private lateinit var myCartViewModel: MyCartViewModelImpl

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
        val dataNetworkInteract = MyCartInteractorImpl(retrofitServices)
        val viewModelFactory = MyCartViewModelFactory(dataNetworkInteract)
        myCartViewModel =
            ViewModelProvider(this, viewModelFactory)[MyCartViewModelImpl::class.java]
        binding.recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        adapterMyCart = MyCartAdapter()
        binding.recyclerView1.adapter = adapterMyCart
        myCartViewModel.onViewCreated()
        initObserves()
        binding.backBtn.setOnClickListener {
           myCartViewModel.onClickedBackToGeneral()
        }
    }

    private fun initObserves() {
        myCartViewModel.myCartModel.observe(viewLifecycleOwner) {
            binding.deliveryFree.text = it.delivery
            binding.priceTotal.text = it.total
        }
        myCartViewModel.listBasketItem.observe(viewLifecycleOwner) {
            adapterMyCart.setDataMyCart(it)
        }
        myCartViewModel.backToGeneralScreen.observe(viewLifecycleOwner) {
            backToGeneralScreen()
        }
    }

    private fun backToGeneralScreen() {
        findNavController().navigate(R.id.navigation_general_screen)
    }
}




