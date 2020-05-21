package uz.usoft.waiodictionary.api


import retrofit2.Call
import retrofit2.http.GET
import uz.bank.currency.models.CurrencyResponse


interface ApiService {

    @GET("NCIRate")
    fun getCurrency(): Call<CurrencyResponse>

}