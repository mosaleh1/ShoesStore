package com.udacity.shoestore

import androidx.databinding.InverseMethod

object Converters {

    @JvmStatic
    fun stringToDouble(
        value: String
    ): Double {
        // Converts String to long.
        return if (value.trim().replace("\n"," ").isNotEmpty())
            value.toDouble()
        else
            0.0
    }

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(
        value: Double
    ): String {
        // Converts long to String.
        return value.toString()
    }


}