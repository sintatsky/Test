package com.sintatsky.astest.presentation.screens.tab_items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sintatsky.astest.R


class UsNewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_us_news, container, false)
    }

    companion object {
        fun newInstance() = UsNewsFragment()
    }
}