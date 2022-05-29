package com.dima.timer_air.breav_sesion.Viev

import android.content.pm.PackageInstaller
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dima.timer_air.R
import com.dima.timer_air.breav_sesion.Params
import com.dima.timer_air.breav_sesion.visiaModel.BrifVievModel

class BreafFragmen: Fragment() {
    val viewModel: BrifVievModel = BrifVievModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_breathsesion,
        container,
        false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listener = this

        val inhaleValue1  = view.findViewById<TextView>(R.id.VdohViev)
        val inhaleValue2 = view.findViewById<TextView>(R.id.VdohViev2)
        val exhaleeValue1 = view.findViewById<TextView>(R.id.VudohViev1)
        val exhaleeValue2 = view.findViewById<TextView>(R.id.VudohViev2)

        inhaleValue1.text = viewModel.parameters.inhale.toString()
        inhaleValue2.text = viewModel.parameters.sessionDeley1.toString()
        exhaleeValue1.text = viewModel.parameters.sessionDeley2.toString()
        exhaleeValue2.text = viewModel.parameters.exhale.toString()


        view.findViewById<Button>(R.id.StartButton).setOnClickListener {
            viewModel.startSession()
        }
    }

    fun setStartEnabled(vaule: Boolean) {
        view?.findViewById<Button>(R.id.StartButton)?.isEnabled = vaule
    }

    fun onChange(newValues: Params) {
        val inhaleValue1  = view?.findViewById<TextView>(R.id.VdohViev)
        val inhaleValue2 = view?.findViewById<TextView>(R.id.VdohViev2)
        val exhaleeValue1 = view?.findViewById<TextView>(R.id.VudohViev1)
        val exhaleeValue2 = view?.findViewById<TextView>(R.id.VudohViev2)

        inhaleValue1?.text = newValues.inhale.toString()
        inhaleValue2?.text = newValues.sessionDeley1.toString()
        exhaleeValue1?.text = newValues.sessionDeley2.toString()
        exhaleeValue2?.text = newValues.exhale.toString()
    }
}