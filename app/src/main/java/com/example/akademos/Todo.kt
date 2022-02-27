package com.example.akademos

class todo {
    var todoArray : Array<String> =  arrayOf<String>()
    fun todolst( element: String): Array<String> {
        var task: MutableList<String> = todoArray.toMutableList()
        task.add(element)
        return task.toTypedArray()
    }
    fun delete( index: Int) {
        if (!(index < 0 || index >= todoArray.size)){
            var rem: MutableList<String> = todoArray.toMutableList()
            var new = rem.removeAt(index)
        }
    }
    fun modify( index: Int, element: String): Array<String> {
        var newtask: MutableList<String> = todoArray.toMutableList()
        newtask[index] = element
        return newtask.toTypedArray()
    }
    }
