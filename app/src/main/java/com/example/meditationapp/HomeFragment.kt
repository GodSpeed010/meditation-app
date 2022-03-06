package com.example.meditationapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*


class HomeFragment : Fragment() {
    val TAG = "HomeFragment"

    lateinit var rvDays: RecyclerView
    lateinit var adapter: DaysAdapter
    var days = listOf(
        Day(1, "Nunc eget sit verr", "suluarh"),
        Day(2, "Nuncaot sit verr", "suluarh"),
        Day(3, "au oeu sit verr", "suluarh"),
        Day(4, "simth eget sit verr", "suluarh")
    )

    lateinit var btWeekBackward: ImageButton
    lateinit var btWeekForward: ImageButton
    lateinit var tvWeekDate: TextView
    lateinit var bottomNav: BottomNavigationView
    lateinit var tvDaysRemainingMsg: TextView

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        rvDays = view.findViewById(R.id.rvDays)
        btWeekBackward = view.findViewById(R.id.btWeekBackward)
        btWeekForward = view.findViewById(R.id.btWeekForward)
        tvWeekDate = view.findViewById(R.id.tvWeekDate)
        tvDaysRemainingMsg = view.findViewById(R.id.tvDaysRemainingMsg)

        btWeekBackward.setOnClickListener { Log.i(TAG, "back clicked") }
        btWeekForward.setOnClickListener { Log.i(TAG, "forward clicked") }

        setupUI()

        bottomNav = view.findViewById(R.id.bottom_nav)
        navController = this.findNavController()

        return view
    }
    
    private fun setupUI() {
        setupRecyclerView()

        //Display the starting date for current week
        val calendar: Calendar = Calendar.getInstance()
        val pattern = Regex(" [0-9][0-9]:.*")
        tvWeekDate.text = "The week of ${pattern.replace(calendar.time.toString(), "")}"

        //Display the numerical day of the week
        tvDaysRemainingMsg.text = "You are on day ${Calendar.DAY_OF_WEEK} of\n this week's meditation"
    }

    private fun setupRecyclerView() {

        val clickListener = object : DaysAdapter.ClickListener {
            override fun onQueueClicked(position: Int) {
                Log.i(TAG, "onQueueClicked")

                //todo navigate to media player fragment

                navController.navigate(R.id.action_homeFragment_to_playerFragment)
            }
        }

        adapter = DaysAdapter(days, clickListener)
        rvDays.adapter = adapter
    }
}