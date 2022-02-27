package com.example.akademos

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.akademos.ui.main.SectionsPagerAdapter
import com.example.akademos.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var rem : ReminderList = ReminderList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = binding.fab



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

    override fun onDestroy() {
        super.onDestroy();
        for (i in 0..this.rem.reminders.size) {
            val sharedPreferences: SharedPreferences = this.getSharedPreferences(this.rem.reminders[i] as String?, Context.MODE_PRIVATE)
            val save = sharedPreferences.edit()
            save.putString("Reminder $i", rem.reminders[i] as String?)
            save.apply()
            save.commit()
        }
    }


}