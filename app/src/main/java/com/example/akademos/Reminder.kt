package com.example.akademos

import java.util.*


class Reminder(private val message: String, private val time: Calendar){

    var reminderMessage : String = message + " is set for " + time.time.toString()

    fun printReminder(){
        println(reminderMessage)
    }





    fun getMessage() : String{
        return message
    }

    fun getTime() : Calendar{
        return time
    }














    override fun equals(other: Any?): Boolean{
        if(other == null){
            return false
        }
        if(!(other::class.equals(this::class))){
            return false
        }
        val otherReminder : Reminder = other as Reminder

        if(!otherReminder.getMessage().equals(this.getMessage())){
            return false
        }
        if(!otherReminder.getTime().equals(this.getTime())){
            return false
        }
        return true
    }
}