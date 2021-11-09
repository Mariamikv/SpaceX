package com.example.spacex.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex.adapters.DetailsAdapter
import com.example.spacex.databinding.FragmentDetailBinding
import com.example.spacex.models.launches.Launches
import com.example.spacex.utils.BaseFragment
import org.koin.android.ext.android.get


class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val detailAdapter = DetailsAdapter()
    private val viewModel = get<DetailFragmentViewModel>()

    //searchView
    private var matchedship: ArrayList<Launches> = arrayListOf()
    private var shipData: ArrayList<Launches> = arrayListOf()

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        viewModel.init()

        observe()

        binding.detailRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = detailAdapter
        }

        //searchView
        binding.searchView.isSubmitButtonEnabled = true
        search()
    }

    private fun search(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                startSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                startSearch(newText)
                return true
            }

        })
    }

    private fun startSearch(text: String?){
        matchedship = arrayListOf()

        text?.let {
            shipData.forEach{
                if(it.missionName?.contains(text, true) == true){
                    matchedship.add(it)
                }
            }

            updateRecyclerView()
            if(matchedship.isEmpty()){
                Toast.makeText(context, "No match Found!", Toast.LENGTH_LONG).show()
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView(){
        binding.detailRecycler.apply {
            detailAdapter.setMissionData(matchedship)
            detailAdapter.notifyDataSetChanged()
        }
    }

    private fun observe(){
        viewModel._missionLiveData.observe(viewLifecycleOwner, {
            detailAdapter.setMissionData(it)
            shipData = arrayListOf()
            shipData.addAll(it)
        })
    }
}










