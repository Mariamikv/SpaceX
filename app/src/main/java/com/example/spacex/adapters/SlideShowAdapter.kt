package com.example.spacex.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.spacex.R
import com.example.spacex.databinding.SlideShowLayoutBinding
import com.example.spacex.extension.setImageUrl
import com.example.spacex.interfaces.SetOnClickListener
import com.example.spacex.models.Ship

class SlideShowAdapter(val viewPager: ViewPager2):  RecyclerView.Adapter<SlideShowAdapter.ViewHolder>(){

    private val shipData = mutableListOf<Ship>()
    private var onClickListener: SetOnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dataHolder = SlideShowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(dataHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = shipData.size

    inner class ViewHolder(private val binding: SlideShowLayoutBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var dataModel: Ship

        fun bind(){
            dataModel = shipData[adapterPosition]
            with(binding){
                if(dataModel.image!=null){
                    image.setImageUrl(Uri.parse(dataModel.image))
                }else{
                    image.setImageUrl(Uri.parse("https://i.kym-cdn.com/entries/icons/original/000/027/100/_103330503_musk3.jpg"))
                }

                shipName.text = dataModel.shipName
                shipType.text = dataModel.shipType
                homePort.text = dataModel.homePort

                root.setOnClickListener {
                    onClickListener?.onClick(adapterPosition)
                }
            }

            if(adapterPosition==shipData.size-2){
                viewPager.post(run)
            }
        }
    }

    val run = Runnable {
        shipData.addAll(shipData)
        notifyDataSetChanged()
    }

    fun setOnClickListener(onClickListener: SetOnClickListener){
        this.onClickListener = onClickListener
    }

    fun setData(data: List<Ship>){
        shipData.clear()
        shipData.addAll(data)
        notifyDataSetChanged()
    }
}