package com.dima.timer_air.breav_sesion.visiaModel

import android.os.CountDownTimer
import com.dima.timer_air.breav_sesion.Params
import com.dima.timer_air.breav_sesion.Viev.BreafFragmen

class BrifVievModel
{
    val parameters = Params(
        10,
        2,
        1,
        1,
        3,
    )

    val currentParameters = parameters.copy()
    var listener: BreafFragmen? = null
    var timer: CountDownTimer? = null


    fun startSession()
    {
        timer = object : CountDownTimer(
            parameters.sessionLength  * 1000L,
        1000L
        ) {
            override fun onTick(p0: Long) {
                updateSession()
                listener?.onChange(currentParameters)
            }

            override fun onFinish() {
                listener?.setStartEnabled(true)
            }
        }
        timer?.start()
        listener?.setStartEnabled(false)
    }

    fun updateSession()
    {
        currentParameters.sessionLength -= 1

        if (currentParameters.inhale > 0) {
            currentParameters.inhale -= 1
        }else if (currentParameters.sessionDeley1 > 0) {
            currentParameters.sessionDeley1 -= 1
        }else if (currentParameters.exhale > 0) {
            currentParameters.exhale -= 1
        }else if (currentParameters.sessionDeley2 > 0) {
            currentParameters.sessionDeley2 -= 1
        }

        if(currentParameters.sessionDeley2 == 0) {
            currentParameters.inhale = parameters.inhale
            currentParameters.exhale = parameters.exhale
            currentParameters.sessionDeley1 = parameters.sessionDeley1
            currentParameters.sessionDeley2 = parameters.sessionDeley2
        }
    }
}