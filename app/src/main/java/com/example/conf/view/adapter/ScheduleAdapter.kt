package com.example.conf.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conf.R
import com.example.conf.model.Conference
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ScheduleAdapter(val scheduleListener: ScheduleListener): RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    var listConference = ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        val conference = listConference[position] as Conference
        holder.tvConferenceName.text = conference.title
        holder.tvConferenceSpeaker.text = conference.speaker
        holder.tvConferenceTag.text = conference.tag

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val simpleDateFormatAMPM = SimpleDateFormat("a")

        val cal = Calendar.getInstance()
        cal.time = conference.datetime
        val hourFormat = simpleDateFormat.format(conference.datetime)

        holder.tvConferenceHour.text = hourFormat
        holder.tvConferenceAMPM.text = simpleDateFormatAMPM.format(conference.datetime).toUpperCase()
    }

    fun updateData(data: List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() =  listConference.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheduleTag)
        val tvConferenceHour= itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
    }

}