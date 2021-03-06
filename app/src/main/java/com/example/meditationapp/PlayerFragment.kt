package com.example.meditationapp

import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.navArgs

class PlayerFragment : Fragment() {

    private val TAG = "PlayerFragment"
    private lateinit var ibPlayPause: ImageButton
    private lateinit var ibForwardTen: ImageButton
    private lateinit var ibBackwardTen: ImageButton
    private lateinit var seekbar: SeekBar
    private lateinit var tvCurrentWeek: TextView

    private val args by navArgs<PlayerFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_player, container, false)

        ibPlayPause = view.findViewById(R.id.ib_playPause)
        ibBackwardTen = view.findViewById(R.id.ibBackwardTen)
        ibForwardTen = view.findViewById(R.id.ibForwardTen)
        seekbar = view.findViewById(R.id.seekBar)
        tvCurrentWeek = view.findViewById(R.id.tvCurrentWeek)

        tvCurrentWeek.text = args.weekStart

        var isPlaying = false
        ibPlayPause.setOnClickListener {
            Log.d(TAG, "play/pause button clicked")

            if (isPlaying) {
                ibPlayPause.setBackgroundDrawable(resources.getDrawable(R.drawable.ic_play_circle))
                isPlaying = !isPlaying
            } else {
                ibPlayPause.setBackgroundDrawable(resources.getDrawable(R.drawable.ic_pause_circle))
                isPlaying = !isPlaying
            }
        }

        ibBackwardTen.setOnClickListener {
            seekbar.progress -= 10
        }
        ibForwardTen.setOnClickListener {
            seekbar.progress += 10
        }


        return view
    }

}