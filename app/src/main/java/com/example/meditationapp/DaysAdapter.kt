package com.example.meditationapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DaysAdapter(val days: List<Day>, val clickListener: ClickListener) : RecyclerView.Adapter<DaysAdapter.ViewHolder>() {
    interface ClickListener {
        fun onQueueClicked(position: Int)
    }
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDayNumber: TextView = itemView.findViewById(R.id.tvDayNumber)
        val tvDayTitle: TextView = itemView.findViewById(R.id.tvDayTitle)
        val tvDayBody: TextView = itemView.findViewById(R.id.tvDayBody)

        val ivDownload: ImageButton = itemView.findViewById(R.id.ivDownload)
        val ivQueueMusic: ImageButton = itemView.findViewById(R.id.ivQueueMusic)
        val ivHeart: ImageButton = itemView.findViewById(R.id.ivHeart)

        init {
            ivQueueMusic.setOnClickListener {
                clickListener.onQueueClicked(adapterPosition)
            }
        }
    }
}