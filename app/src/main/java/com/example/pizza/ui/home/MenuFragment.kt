package com.example.pizza.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.pizza.SubApplication
import com.example.pizza.databinding.FragmentPizzaListBinding
import com.example.pizza.retrofit.RetrofitServices
import retrofit2.create


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentPizzaListBinding
    private lateinit var adapterMenu: AdapterMenu
    private lateinit var adapterCategory: AdapterCategory
    private lateinit var imageViewPagerAdapter: ImageViewPagerAdapter
    private lateinit var mServices: RetrofitServices
    private lateinit var menuViewModel: MenuViewModel
     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentPizzaListBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUrlList = listOf(
            "https://images.unsplash.com/photo-1621318164984-b06589834c91?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1621551122354-e96737d64b70?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1621616875450-79f024a8c42c?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080",
            "https://images.unsplash.com/photo-1621687947404-e41b3d139088?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwxOTU3MDZ8MHwxfHJhbmRvbXx8fHx8fHx8fDE2MjM2OTk4MjI&ixlib=rb-1.2.1&q=80&w=1080"
        )
        imageViewPagerAdapter = ImageViewPagerAdapter(imageUrlList)
            //TODO переименовать
        mServices = (requireContext().applicationContext as SubApplication).provideDataFromNetwork().create()
        val dataCategory =
            (requireContext().applicationContext as SubApplication).provideDataSource()
                .getCategoryList()
        //TODO переименовать
        val inter = DataNetworkInteract(mServices, dataCategory)
        val viewModelFactory = PizzaListViewModelFactory(inter)
        menuViewModel =
            ViewModelProvider(this, viewModelFactory)[MenuViewModel::class.java]
        //TODO переименовать
        adapterMenu = AdapterMenu()
        //TODO переименовать
        menuViewModel.onViewCreatedPizza()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapterMenu
        adapterCategory = AdapterCategory()
        binding.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext())
        //TODO покопаться
        (binding.recyclerViewCategory.layoutManager as LinearLayoutManager).orientation =
            LinearLayoutManager.HORIZONTAL
        binding.recyclerViewCategory.adapter = adapterCategory
        binding.viewPager.adapter = imageViewPagerAdapter
        setUpViewPager()
        initObserves()
    }
    //TODO apply with

    private fun initObserves() {
        menuViewModel.loadingListCategory.observe(requireActivity()) {
            adapterCategory.setDataCategory(it)
        }
        menuViewModel.loadingListPizza.observe(requireActivity()) {
            adapterMenu.setDataPizza(it)
        }
    }
    private fun setUpViewPager() {
        binding.viewPager.adapter = imageViewPagerAdapter
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

}