package com.example.akademos.ui.main

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.akademos.AlarmReceiver
import com.example.akademos.R

class PromodroFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.promodro_fragment, container, false)
        val btn = view.findViewById<Button>(R.id.promodro_btn)
        btn.setOnClickListener {
            val AlarmMgr = container?.context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val Alarm = Intent(container?.context, AlarmReceiver::class.java)
            Alarm.putExtra("Message","Wassup")
            val pendingIntent = PendingIntent.getBroadcast(container?.context, 0, Alarm, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmMgr.setExact(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + 60 * 15000, pendingIntent)
        }
        return inflater.inflate(R.layout.promodro_fragment, container, false)
    }

    /**
     * factory method to return instance of fragment class about.
     */
    companion object {
        @JvmStatic
        fun newInstance(): PromodroFragment {
            return PromodroFragment()
        }
    }


}