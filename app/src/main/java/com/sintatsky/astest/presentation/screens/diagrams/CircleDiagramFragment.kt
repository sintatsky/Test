package com.sintatsky.astest.presentation.screens.diagrams

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.sintatsky.astest.R
import com.sintatsky.astest.databinding.FragmentCircleDiagramBinding


class CircleDiagramFragment : Fragment() {

    private var _binding: FragmentCircleDiagramBinding? = null
    private val binding: FragmentCircleDiagramBinding
        get() = _binding ?: throw RuntimeException("CircleDiagramFragment is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCircleDiagramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = mutableListOf<PieEntry>().apply {
            add(PieEntry(38f, getString(R.string.one_day)))
            add(PieEntry(107f, getString(R.string.two_days)))
            add(PieEntry(163f, getString(R.string.three_days)))
            add(PieEntry(222f, getString(R.string.four_days)))
        }

        val pieDataSet = PieDataSet(list, getString(R.string.night_count))
        pieDataSet.colors = ColorTemplate.MATERIAL_COLORS.asList()
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 25f

        val pieData = PieData(pieDataSet)

        with(binding.pierChart) {
            data = pieData
            description.text = (context.getString(R.string.duration))
            description.isEnabled = false
            centerText = context.getString(R.string.text_description)
            animate()
        }
    }

    companion object {
        fun newInstance() = CircleDiagramFragment()
    }
}