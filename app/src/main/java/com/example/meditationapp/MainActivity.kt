package com.example.meditationapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivityTag"

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btWeekBackward = findViewById(R.id.btWeekBackward)
        btWeekForward = findViewById(R.id.btWeekForward)
        tvWeekDate = findViewById(R.id.tvWeekDate)
        tvDaysRemainingMsg = findViewById(R.id.tvDaysRemainingMsg)

        btWeekBackward.setOnClickListener { Log.i(TAG, "back clicked") }
        btWeekForward.setOnClickListener { Log.i(TAG, "forward clicked") }

        setupUI()

//        bottomNav = findViewById(R.id.bottom_nav)
//        val navController = findNavController(R.id.nav_fragment)
//        bottomNav.setupWithNavController(navController)
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
        rvDays = findViewById(R.id.rvDays)

        val clickListener = object : DaysAdapter.ClickListener {
            override fun onQueueClicked(position: Int) {
                Log.i(TAG, "onQueueClicked")

//                val i = Intent()
            }
        }

        adapter = DaysAdapter(days, clickListener)
        rvDays.adapter = adapter
    }
}