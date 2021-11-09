package com.example.spacex.ui.home

import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.spacex.adapters.SlideShowAdapter
import com.example.spacex.databinding.HomeFragmentBinding
import com.example.spacex.interfaces.SetOnClickListener
import com.example.spacex.utils.BaseFragment
import org.koin.android.ext.android.get

class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private val viewModel = get<HomeViewModel>()
    private lateinit var slideShowAdapter: SlideShowAdapter
    private lateinit var sliderHandler: Handler
    private lateinit var sliderRun: Runnable


    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
       init()
    }

    private fun init(){
        viewModel.init()
        itemSliderView()
        observe()
    }

    private fun itemSliderView(){
        slideShowAdapter = SlideShowAdapter(binding.shipsViewPager)
        with(binding){
            shipsViewPager.adapter = slideShowAdapter
            shipsViewPager.clipToPadding = false
            shipsViewPager.clipChildren = false
            shipsViewPager.offscreenPageLimit = 3
            shipsViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        val comPosTarget = CompositePageTransformer()
        comPosTarget.addTransformer(MarginPageTransformer(40))
        comPosTarget.addTransformer{ page, position ->
            val r: Float = 1- kotlin.math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        binding.shipsViewPager.setPageTransformer(comPosTarget)

        sliderHandler = Handler()
        sliderRun = Runnable {
            binding.shipsViewPager.currentItem = binding.shipsViewPager.currentItem+1
        }

        binding.shipsViewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderHandler.removeCallbacks(sliderRun)
                    sliderHandler.postDelayed(sliderRun, 5000)
                }
            }
        )

        binding.speedButton.setOnClickListener {
            binding.shipsViewPager.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        sliderHandler.removeCallbacks(sliderRun)
                        sliderHandler.postDelayed(sliderRun, 1000)
                    }
                }
            )
        }

        binding.stopButton.setOnClickListener{
            sliderHandler.removeCallbacks(sliderRun)
        }

        slideShowAdapter.setOnClickListener(object : SetOnClickListener{
            override fun onClick(position: Int) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
                findNavController().navigate(action)
            }

        })

    }

    private fun observe(){
        viewModel._shipLiveData.observe(viewLifecycleOwner, {
            slideShowAdapter.setData(it)
        })
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRun)
    }

    override fun onDestroy() {
        super.onDestroy()
        sliderHandler.postDelayed(sliderRun, 5000)
    }
}