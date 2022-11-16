package com.example.pizza.ui.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.pizza.DataCategory
import com.example.pizza.R
import com.example.pizza.SubApplication
import com.example.pizza.databinding.FragmentGeneralScreenBinding
import com.example.pizza.retrofit.RetrofitServices
import com.example.pizza.ui.product.ProductDetailsFragment
import javax.inject.Inject


class GeneralScreenFragment : Fragment(), ViewListener {
    private lateinit var binding: FragmentGeneralScreenBinding
    private lateinit var adapterBestSeller: AdapterBestSeller
    private lateinit var viewPagerAdapterHomeStore: HomeStoreAdapter
    private lateinit var generalScreenViewModel: GeneralScreenViewModel
    private lateinit var adapterCategory:CategoryAdapter
    @Inject
    lateinit var dataNetworkInteract: DataNetworkInteract
    @Inject
     lateinit var retrofitServices: RetrofitServices
     @Inject
    lateinit var dataCategory: List<DataCategory>
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

      //  retrofitServices =
      //      (requireContext().applicationContext as SubApplication).provideDataFromNetwork()
      //          .create()
      //  val listDataCategory =
      //      (requireContext().applicationContext as SubApplication).provideDataSource()
       //         .getCategoryList()
      //  val dataNetworkInteract = DataNetworkInteract(retrofitServices, listDataCategory)
        val viewModelFactory = GeneralScreenViewModelFactory(dataNetworkInteract)
        generalScreenViewModel =
            ViewModelProvider(this, viewModelFactory)[GeneralScreenViewModel::class.java]
        generalScreenViewModel.onViewCreatedLoadingList()
        viewPagerAdapterHomeStore = HomeStoreAdapter()
        adapterBestSeller = AdapterBestSeller(this)
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapterBestSeller

        binding.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext())
        //TODO покопаться
        (binding.recyclerViewCategory.layoutManager as LinearLayoutManager).orientation =
            LinearLayoutManager.HORIZONTAL
        adapterCategory = CategoryAdapter()
        binding.recyclerViewCategory.adapter = adapterCategory
        binding.viewPager.adapter = viewPagerAdapterHomeStore
        setUpViewPager()
        initObserves()
        binding.filterBtn.setOnClickListener {
             generalScreenViewModel.openFilter.observe(requireActivity()){
                 openFilter()
             }

        }
    }

    //TODO apply with

    private fun initObserves() {
        generalScreenViewModel.loadingListCategory.observe(requireActivity()) {
            adapterCategory.setDataCategory(it)
        }
        generalScreenViewModel.loadingListBestSeller.observe(requireActivity()) {
            adapterBestSeller.setDataBestSeller(it)
        }
        generalScreenViewModel.loadingHomeStore.observe(requireActivity()) {
            viewPagerAdapterHomeStore.setDataHomeStore(it)
        }
        generalScreenViewModel.openProductDetails.observe(requireActivity()) {
            openProductDetails(it)
        }
    }

    private fun setUpViewPager() {
        binding.viewPager.adapter = viewPagerAdapterHomeStore
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    override fun onClicked(position: String) {
        generalScreenViewModel.onClickedDetail(position)
    }

    //TODO разобраться со стеком
    private fun openProductDetails(CPU: String) {
        findNavController().navigate(R.id.product_details)
      /*  requireActivity().supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, ProductDetailsFragment.newInstance(CPU))
            .commit()*/
    }

    private fun openFilter() {
        val myDialogFragment = FilterOptionDialog()
        val manager = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        myDialogFragment.show(transaction, "dialog")
    }
}