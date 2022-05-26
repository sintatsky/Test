package com.sintatsky.astest.presentation.screens.diagrams

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.sintatsky.astest.R
import com.sintatsky.astest.databinding.FragmentCircleDiagramBinding
import java.lang.RuntimeException


class CircleDiagramFragment : Fragment() {

    private var _binding: FragmentCircleDiagramBinding? = null
    private val binding: FragmentCircleDiagramBinding
        get() = _binding ?: throw RuntimeException("CircleDiagramFragment is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCircleDiagramBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<PieEntry>().apply {
            add(PieEntry(38f,"1 сутки"))
            add(PieEntry(107f,"2 суток"))
            add(PieEntry(163f,"3 суток"))
            add(PieEntry(222f,"4 суток"))
        }

        val pieDataSet = PieDataSet(list, "Количество ночей")
        pieDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 25f

        val pieData = PieData(pieDataSet)

        with(binding.pierChart){
            setData(pieData)
            description.text = ("Продолжительность пребывания")
            description.isEnabled = false
            setCenterText("Продолжительность пребывания туристов в Санкт-Петербурге в 2021г")
            animate()
        }
    }

    companion object {
        fun newInstance() = CircleDiagramFragment()
    }
}