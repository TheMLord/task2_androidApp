package com.example.habitstracker

import com.example.habitstracker.model.Habits
import kotlin.properties.Delegates

class DataHabits {

    private lateinit var listHabits : MutableMap<Int, Habits>

    fun addHabits(id : Int, habits: Habits) {
        this.listHabits[id] = habits
    }
    fun getLenData(): Int {
        return this.listHabits.size
    }
}