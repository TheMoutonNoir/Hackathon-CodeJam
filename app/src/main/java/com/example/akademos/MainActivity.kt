package com.example.akademos

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.akademos.ui.main.SectionsPagerAdapter
import com.example.akademos.databinding.ActivityMainBinding
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.core.content.ContextCompat.getSystemService
import android.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var alarmMgr: AlarmManager? = null
    private lateinit var alarmIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val AlarmMgr = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val Alarm = Intent(this, AlarmReceiver::class.java)
        Alarm.putExtra("Message","Wassup")
        val pendingIntent = PendingIntent.getBroadcast(this, 0, Alarm, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmMgr.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime() + 60 * 200, pendingIntent)


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}