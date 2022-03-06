package com.example.meditationapp

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
        Day(1, "Nuncaot sit verr", "suluarh"),
        Day(2, "au oeu sit verr", "suluarh"),
        Day(3, "simth eget sit verr", "suluarh")
    )

    lateinit var btWeekBackward: ImageButton
    lateinit var btWeekForward: ImageButton
    lateinit var tvWeekDate: TextView
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btWeekBackward = findViewById(R.id.btWeekBackward)
        btWeekForward = findViewById(R.id.btWeekForward)
        tvWeekDate = findViewById(R.id.tvWeekDate)

        rvDays = findViewById(R.id.rvDays)
        adapter = DaysAdapter(days)
        rvDays.adapter = adapter

        btWeekBackward.setOnClickListener { Log.i(TAG, "back clicked") }
        btWeekForward.setOnClickListener { Log.i(TAG, "forward clicked") }

        val calendar: Calendar = Calendar.getInstance()
        Log.d(TAG, "1st day of week ${calendar.firstDayOfWeek}")
        calendar.add(Calendar.DAY_OF_MONTH, Calendar.MONDAY - calendar.get(Calendar.DAY_OF_WEEK)-7)
        Log.i(TAG, "first day of week" + calendar.time)

        val pattern = Regex(" [0-9][0-9]:.*")
        tvWeekDate.text = "The week of ${pattern.replace(calendar.time.toString(), "")}"

        bottomNav = findViewById(R.id.bottom_nav)
        val navController = findNavController(R.id.nav_fragment)
        bottomNav.setupWithNavController(navController)
    }
}