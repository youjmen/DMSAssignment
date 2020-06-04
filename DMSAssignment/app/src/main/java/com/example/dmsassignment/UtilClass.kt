package com.example.dmsassignment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log

class UtilClass {
    companion object {
        var pref: SharedPreferences? = null





        fun getUsername(context: Context): String {
            pref = context.getSharedPreferences("DMSAssignment", MODE_PRIVATE)
            return pref?.getString("username", "default")!!
        }

        fun saveUsername(context: Context, username: String) {
            pref = context.getSharedPreferences("DMSAssignment", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = pref!!.edit()
            editor.putString("username", username)
            editor.apply()
        }
        fun changeUsername(context: Context, username: String) {
            pref = context.getSharedPreferences("DMSAssignment", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = pref!!.edit()
            editor.putString("username", username)
            editor.apply()
        }
    }

}