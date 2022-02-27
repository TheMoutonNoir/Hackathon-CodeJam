package com.example.akademos

import android.content.Context
import android.content.SharedPreferences
import java.time.LocalDate
import java.util.*

class ReminderList {
    var reminders = arrayListOf<Reminder>()

    //The parameters are temporary, they're just there so we can test, in reality the addReminder should create textfields and have the
    //user write numerically(?) the min,hour,day,month.

    fun addReminder(month: Int, day: Int, hour: Int, minute: Int) {

        //Add a text field that specifies what reminder message to put, for now temp @Stef
        var reminderMessage: String = "default reminder I guess"

        //Either use some Calendar UI implementation or have more text fields that specify the time and day @Stef
        var reminderMinute: Int = minute
        var reminderHour: Int = hour
        var reminderDay: Int = day
        var reminderMonth: Int = month
        //Again, textfields or you'll have to change a bunch of the code so that it works with the Calendar UI implementation OR text fields @Stef
        var date: Date = Date()
        date.minutes = reminderMinute
        date.hours = reminderHour
        date.date = reminderDay

        val currentDate: Date = Calendar.getInstance().time
        date.month = reminderMonth

        if (reminderMonth < currentDate.month) {
            date.year = currentDate.year + 1
        } else {
            date.year =
                currentDate.year + 1900 //Spooky idk why I have to do +1900 because by default it does 122... but oh well
        }

        var newCalendar: Calendar = Calendar.getInstance()
        newCalendar.set(date.year, reminderMonth, reminderDay, reminderHour, reminderMinute, 0)

        reminders.add(Reminder(reminderMessage, newCalendar))


    }

    fun printReminders() {
        for (rem: Reminder in reminders) {
            println(rem.toString() + "\n============")
        }
    }

    fun remindersToStringList() {
        var reminderString = arrayListOf<String>()
        for (i in 0..reminders.size) {
            reminderString[i] = reminders[i].toString()
        }
    }




}