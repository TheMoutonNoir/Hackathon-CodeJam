package com.example.akademos

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.akademos.ui.main.SectionsPagerAdapter
import com.example.akademos.databinding.ActivityMainBinding
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.core.content.ContextCompat.getSystemService
import android.R
import com.example.akademos.ui.main.PromodroFragment
import com.example.akademos.ui.main.ReminderFragment
import com.example.akademos.ui.main.ToDoFragement
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)

        //add fragments
        sectionsPagerAdapter.addFragment(PromodroFragment.newInstance())
        sectionsPagerAdapter.addFragment(ToDoFragement.newInstance())
        sectionsPagerAdapter.addFragment(ReminderFragment.newInstance())
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = binding.fab


        var rem : ReminderList = ReminderList()

        rem.addReminder(4,28,4,30)
        rem.addReminder(5,30,12,40)
        rem.addReminder(6,14,23,0)
        rem.addReminder(4,19,9,53)
        rem.printReminders()



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()



        }

    }
}