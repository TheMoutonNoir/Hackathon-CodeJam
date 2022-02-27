package com.example.akademos.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.akademos.R
import com.example.akademos.databinding.FragmentMainBinding

class ToDoFragement: Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.to_do_fragment, container, false)
        val TodoView = inflater.inflate(R.layout.to_do_fragment, container, false)
        listView = view.findViewById<ListView>(R.id.todo_list_view)
        val listToDo = ArrayList<String>()
        listToDo.add("Study Cal 3")
        listToDo.add("Finish Web Dev Project")
        val adapter = container?.context?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1 , listToDo) }
        listView.adapter = adapter
        return view
    }



    /**
     * factory method to return instance of fragment class about.
     */
    companion object {
        @JvmStatic
        fun newInstance(): ToDoFragement {
            return ToDoFragement()
        }
    }


}