package com.example.pizza.general.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.pizza.general.model.CategoryModel
import com.example.pizza.R
import com.example.pizza.SubApplication
import com.example.pizza.databinding.FragmentGeneralScreenBinding
import com.example.pizza.general.interactor.GeneralScreenInteractorImpl
import com.example.pizza.general.ui.bestselleradapter.BestSellerAdapter
import com.example.pizza.general.ui.bestselleradapter.BestSellerListener
import com.example.pizza.general.ui.categoryadapter.CategoryAdapter
import com.example.pizza.general.ui.categoryadapter.CategoryAdapterListener
import com.example.pizza.general.ui.homestoreadapter.HomeStoreAdapter
import com.example.pizza.general.vm.GeneralScreenViewModelFactory
import com.example.pizza.general.vm.GeneralScreenViewModelImpl
import com.example.pizza.retrofit.RetrofitServices
import javax.inject.Inject


class GeneralScreenFragment : Fragment(), BestSellerListener, CategoryAdapterListener {
    private lateinit var binding: FragmentGeneralScreenBinding
    private lateinit var adapterBestSeller: BestSellerAdapter
    private lateinit var viewPagerAdapterHomeStore: HomeStoreAdapter
    private lateinit var generalScreenViewModel: GeneralScreenViewModelImpl
    private lateinit var adapterCategory: CategoryAdapter
    @Inject
    lateinit var dataNetworkInteract: GeneralScreenInteractorImpl

    @Inject
    lateinit var retrofitServices: RetrofitServices

    @Inject
    lateinit var dataCategory: List<CategoryModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentGeneralScreenBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appComponent = (requireContext().applicationContext as SubApplication).appComponent
        appComponent.getGeneralScreenComponent().injectGeneralScreenFragment(this)
        val viewModelFactory = GeneralScreenViewModelFactory(dataNetworkInteract)
        generalScreenViewModel =
            ViewModelProvider(this, viewModelFactory)[GeneralScreenViewModelImpl::class.java]
        generalScreenViewModel.onViewCreated()
        viewPagerAdapterHomeStore = HomeStoreAdapter()
        adapterBestSeller = BestSellerAdapter(this)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapterBestSeller

        binding.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext())
        (binding.recyclerViewCategory.layoutManager as LinearLayoutManager).orientation =
            LinearLayoutManager.HORIZONTAL
        adapterCategory = CategoryAdapter(this)
        binding.recyclerViewCategory.adapter = adapterCategory
        binding.viewPager.adapter = viewPagerAdapterHomeStore
        setUpViewPager()
        initObserves()
        binding.filterBtn.setOnClickListener {
          generalScreenViewModel.onFilterClicked()
        }
    }

    private fun initObserves() {
        generalScreenViewModel.categoryCheckedEvent.observe(viewLifecycleOwner) {
            adapterCategory.setNewDataCategory(it)
        }
        generalScreenViewModel.bestSellerModel.observe(viewLifecycleOwner) {
            adapterBestSeller.setDataBestSeller(it)
        }
        generalScreenViewModel.homeStoreModel.observe(viewLifecycleOwner) {
            viewPagerAdapterHomeStore.setDataHomeStore(it)
        }
        generalScreenViewModel.openProductDetails.observe(viewLifecycleOwner) {
            openProductDetails(it)
        }
        generalScreenViewModel.openFilter.observe(viewLifecycleOwner) {
            openFilterScreen()
        }
    }

    override fun onCategoryClinked(position: Int) {
        generalScreenViewModel.onCategoryClicked(position)
    }

    private fun setUpViewPager() {
        binding.viewPager.adapter = viewPagerAdapterHomeStore
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    override fun onDetailClicked(position: String) {
        generalScreenViewModel.onDetailClicked(position)
    }

    private fun openProductDetails(CPU: String) {
        findNavController().navigate(R.id.product_details)
    }

    private fun openFilterScreen() {
        val myDialogFragment = FilterOptionDialog()
        val manager = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        myDialogFragment.show(transaction, "dialog")
    }
}