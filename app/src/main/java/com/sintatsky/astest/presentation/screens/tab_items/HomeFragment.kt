package com.sintatsky.astest.presentation.screens.tab_items

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import com.sintatsky.astest.R
import com.sintatsky.astest.utils.Constants


class HomeFragment : Fragment() {

    private lateinit var db: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = FirebaseDatabase.getInstance( "https://test-33247-default-rtdb.europe-west1.firebasedatabase.app").reference

        db.child("results").child("1").addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val news = snapshot.value
                Log.d("FIREBASE", "data: $news")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("FIREBASE", "exception: $error")
            }

        })
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}