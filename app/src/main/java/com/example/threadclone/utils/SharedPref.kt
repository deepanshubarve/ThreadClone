package com.example.threadclone.utils

import android.content.Context.MODE_PRIVATE
import com.google.firebase.database.core.Context
import androidx.core.content.edit

object SharedPref {
    fun storeData(
        name: String,
        email: String,
        username: String,
        bio: String,
        imageUrl: String,
        context: android.content.Context
    ){
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        sharedPreferences.edit {

            putString("name", name)
            putString("email", email)
            putString("username", username)
            putString("bio", bio)
            putString("imageUrl", imageUrl)
            apply()
        }

    }

    fun getUserName(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("username"," ")!!
    }

    fun getName(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("name"," ")!!
    }

    fun getEmail(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("email"," ")!!
    }

    fun getBio(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("bio"," ")!!
    }

    fun getImage(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("imageUrl", " ")!!
    }

}