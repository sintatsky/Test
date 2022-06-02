package com.sintatsky.astest.presentation.screens.tab_items

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.database.*
import com.sintatsky.astest.databinding.FragmentHomeBinding
import com.sintatsky.astest.domain.entity.top_news.TopNewsResult
import com.sintatsky.astest.presentation.adapters.TopNewsListAdapter
import com.sintatsky.astest.utils.Constants.NODE_NEWS
import com.sintatsky.astest.utils.Constants.URL_FROM_REALTIME_DB


class HomeFragment : Fragment() {

    private lateinit var db: DatabaseReference
    private lateinit var topNewsAdapter: TopNewsListAdapter

    val listNews = arrayListOf<TopNewsResult?>()

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topNewsAdapter = TopNewsListAdapter()
        binding.homeFragmentRecyclerView.adapter = topNewsAdapter
        db = FirebaseDatabase.getInstance(URL_FROM_REALTIME_DB).reference
        db.child(NODE_NEWS)
            .addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children) {
                    val news = data.getValue(TopNewsResult::class.java)
                    listNews.add(news)
                }
                topNewsAdapter.submitList(listNews)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("FIREBASE", "exception: $error")
            }
        })
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}