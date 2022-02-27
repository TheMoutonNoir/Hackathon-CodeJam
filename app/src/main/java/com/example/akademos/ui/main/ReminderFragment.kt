package com.example.akademos.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.akademos.R

class ReminderFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reminder_fragment, container, false)
    }

    /**
     * factory method to return instance of fragment class about.
     */
    companion object {
        @JvmStatic
        fun newInstance(): ReminderFragment {
            return ReminderFragment()
        }
    }


}