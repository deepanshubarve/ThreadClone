package com.example.threadclone.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.threadclone.model.ThreadModel
import com.example.threadclone.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User
import com.google.firebase.storage.storage
import java.util.UUID

class HomeViewModel : ViewModel() {

    private val db = FirebaseDatabase.getInstance()
    val thread = db.getReference("thread")

    private var _threadAndUser = MutableLiveData<List<Pair<ThreadModel, UserModel>>>()
    val threadAndUser : LiveData<List<Pair<ThreadModel, UserModel>>> = _threadAndUser

    init {
        fetchThreadAndUser {
            _threadAndUser.value = it
        }
    }

    fun fetchThreadAndUser(onResult : (List<Pair<ThreadModel, UserModel>>) -> Unit){
        thread.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val result : MutableList<Pair<ThreadModel, UserModel>> = mutableListOf()
                for(threadSnapshot in snapshot.children){
                    val therad = threadSnapshot.getValue(ThreadModel :: class.java)
                    therad.let {
                        fetchUserFromThread(it!!){
                             user ->
                             result.add(0,it to user)

                            if(result.size == snapshot.childrenCount.toInt()){
                                onResult(result)
                            }
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun fetchUserFromThread(thread : ThreadModel,onResult : (UserModel) -> Unit){
        db.getReference("users").child(thread.userId)
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(UserModel :: class.java)
                    user?.let(onResult)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
    }



}