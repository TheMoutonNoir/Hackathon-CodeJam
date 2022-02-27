package com.example.akademos.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.akademos.R

class ToDoFragement(private val listToDo: ArrayList<String>): Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.to_do_fragment, container, false)
        listView = view.findViewById<ListView>(R.id.todo_list_view)
        listToDo.add("Study Cal 3")
        listToDo.add("Finish Web Dev Project")
        val btn = view.findViewById<Button>(R.id.button7)
        val txtfield = view.findViewById<EditText>(R.id.editTextTextPersonName2)
        val adapter = container?.context?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1 , listToDo) }
        listView.adapter = adapter
        btn.setOnClickListener{
            adapter?.add(txtfield.text.toString())
        }
        return view
    }




}