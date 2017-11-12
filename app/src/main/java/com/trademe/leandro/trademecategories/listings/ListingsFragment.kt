package com.trademe.leandro.trademecategories.listings

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trademe.leandro.trademecategories.R
import com.trademe.leandro.trademecategories.categories.CategoriesViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject

class ListingsFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ListingsViewModel.Factory

    private lateinit var listingsList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders
                .of(this, factory)
                .get(ListingsViewModel::class.java)

        viewModel.searchResult.observe(this, Observer {
            it?.list?.let { listingsList.adapter = ListingsAdapter(it) }
        })
    }

    override fun onCreateView(
            inflater: LayoutInflater?,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater?.inflate(R.layout.fragment_listings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listingsList = view.findViewById<RecyclerView>(R.id.listings_list)
        listingsList.layoutManager = LinearLayoutManager(context)
    }
}