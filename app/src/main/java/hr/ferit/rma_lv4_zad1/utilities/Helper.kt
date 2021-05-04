package hr.ferit.rma_lv4_zad1.utilities

import hr.ferit.rma_lv4_zad1.R

fun getColorResource(color: String): Int {
    return when (color) {
        "grey" -> R.color.grey
        "blue" -> R.color.blue
        "red" -> R.color.red
        "green" -> R.color.green
        else -> R.color.white
    }
}