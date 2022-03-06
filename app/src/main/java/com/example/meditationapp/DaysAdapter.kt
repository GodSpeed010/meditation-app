package com.example.meditationapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DaysAdapter(val days: List<Day>) : RecyclerView.Adapter<DaysAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        //inflate our item layout
        val view = inflater.inflate(R.layout.day_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DaysAdapter.ViewHolder, position: Int) {
        val day = days[position]

        holder.tvDayNumber.text = "Day ${day.dayNumber}"
        holder.tvDayTitle.text = day.meditationTitle
        holder.tvDayBody.text = day.meditationBody
    }

    override fun getItemCount(): Int {
        return days.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDayNumber = itemView.findViewById<TextView>(R.id.tvDayNumber)
        val tvDayTitle = itemView.findViewById<TextView>(R.id.tvDayTitle)
        val tvDayBody = itemView.findViewById<TextView>(R.id.tvDayBody)


        val ivDownload = itemView.findViewById<ImageButton>(R.id.ivDownload)
        val ivQueueMusic = itemView.findViewById<ImageButton>(R.id.ivQueueMusic)
        val ivHeart = itemView.findViewById<ImageButton>(R.id.ivHeart)
    }
}