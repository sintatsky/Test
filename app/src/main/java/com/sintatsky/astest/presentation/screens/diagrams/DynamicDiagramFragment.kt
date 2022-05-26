package com.sintatsky.astest.presentation.screens.diagrams

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.sintatsky.astest.R
import com.sintatsky.astest.databinding.FragmentDynamicDiagramBinding
import java.lang.RuntimeException


class DynamicDiagramFragment : Fragment() {

    private var _binding: FragmentDynamicDiagramBinding? = null
    private val binding: FragmentDynamicDiagramBinding
        get() = _binding ?: throw RuntimeException("DynamicDiagramFragment is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDynamicDiagramBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<BarEntry>().apply {
            add(BarEntry(2017f,2017.55f))
            add(BarEntry(2018f,16124.02f))
            add(BarEntry(2019f,4040.71f))
            add(BarEntry(2020f,11708.97f))
            add(BarEntry(2021f,65509.87f))
            add(BarEntry(2022f,29440.15f))
        }

        val barDataSet = BarDataSet(list, "Курс Bitcoin за год в USD")
        barDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f

        val barData = BarData(barDataSet)

        with(binding.barChart){
            setFitBars(true)
            setData(barData)
            description.text = ("Bitcoin info")
            animateY(2000)
        }
    }

    companion object {
        fun newInstance() = DynamicDiagramFragment()
    }
}