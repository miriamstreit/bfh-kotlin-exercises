package model

data class Currency(
    val code: String = "",
    val symbol: String = "",
    val rate: String = "",
    val description: String = "",
    val rate_float: Float = 0.0F
)