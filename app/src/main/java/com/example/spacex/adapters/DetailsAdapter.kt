package com.example.spacex.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spacex.databinding.DetailRecyclerLayoutBinding
import com.example.spacex.models.launches.Launches

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {

    private val missionData = mutableListOf<Launches>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val dataHolder = DetailRecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(dataHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = missionData.size

    inner class ViewHolder(private val binding: DetailRecyclerLayoutBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var mission: Launches

        @SuppressLint("SetTextI18n")
        fun bind(){
            mission = missionData[adapterPosition]
            with(binding){
                missionName.text = mission.missionName
                launcherYear.text = "Launcher Year: ${mission.launchYear.toString()}"
                missionUrl.text = mission.links?.articleLink
            }

            binding.missionUrl.setOnClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(mission.links?.articleLink)
                binding.root.context.startActivity(openURL)
            }
        }
    }

    fun setMissionData(data: List<Launches>){
        missionData.clear()
        missionData.addAll(data)
        notifyDataSetChanged()
    }
}