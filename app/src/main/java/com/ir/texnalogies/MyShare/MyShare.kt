package com.ir.texnalogies.MyShare

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ir.texnalogies.UserData.UserData

object MyShare {
private const val NAME = "my_cache_file"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var name: String?
        get() = sharedPreferences.getString("key", "")
        set(value) = sharedPreferences.edit {
            it.putString("key", value)
        }

    var dataList: ArrayList<UserData>?
    get() = gsonToArray(sharedPreferences.getString("dataList" , "[]")!!)
    set(value) = sharedPreferences.edit {
        it.putString("dataList" , listToGson(value!!))
    }

    fun gsonToArray(gsonString: String): ArrayList<UserData> {
        val list = ArrayList<UserData>()

        val type = object : TypeToken<List<UserData>>() {}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }

    fun listToGson(list: ArrayList<UserData>): String {
        var gsonString = "[]"
        gsonString = Gson().toJson(list)
        return gsonString
    }
}