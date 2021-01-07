package com.example.conf.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.conf.R
import com.example.conf.model.Speaker
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlin.collections.ArrayList

class SpeakerAdapter(val speakerListener: SpeakerListener): RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {

    val listSpeaker = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerAdapter.ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = listSpeaker[position] as Speaker
        //holder.ivSpeakerImage = speaker.image
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpakerWork.text = speaker.jobtitle
    }

    fun updateData(data: List<Speaker>){
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() = listSpeaker.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivSpeakerImage = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage)
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvSpakerWork = itemView.findViewById<TextView>(R.id.tvItemSpeakerWork)

    }
}