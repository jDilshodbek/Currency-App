package uz.bank.currency.models

import com.google.gson.annotations.SerializedName


class CurrencyResponse {
    @SerializedName("data")
    val currenyList: List<Currency>? = null
}

data class Currency(
    @SerializedName("buyCourse")
    val buyCourse: Long,
    @SerializedName("sellCourse")
    val sellCourse: Long,
    @SerializedName("cbCourse")
    val cbCourse: Long,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("currencyCode")
    val currencyCode: Int,
    @SerializedName("scale")
    val scale: Int
)