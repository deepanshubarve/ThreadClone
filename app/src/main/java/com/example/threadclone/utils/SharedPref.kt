package com.example.threadclone.utils

import android.content.Context.MODE_PRIVATE

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
        val editor = sharedPreferences.edit()

        editor.putString("name",name)
        editor.putString("email",email)
        editor.putString("username",username)
        editor.putString("bio",bio)
        editor.putString("imageUrl",imageUrl)
        editor.apply()

    }

    fun getUserName(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("username","")!!
    }

    fun getName(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("name","")!!
    }

    fun getEmail(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("email","")!!
    }

    fun getBio(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("bio","")!!
    }

    fun getImage(context: android.content.Context) : String{
        val sharedPreferences =  context.getSharedPreferences("users",MODE_PRIVATE)
        return sharedPreferences.getString("imageUrl","")!!
    }

}