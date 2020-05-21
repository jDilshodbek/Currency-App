package uz.bank.currency

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.bank.currency.adapters.CurrencyAdapter
import uz.bank.currency.models.CurrencyResponse
import uz.usoft.waiodictionary.api.ApiClient

class MainActivity : AppCompatActivity() {

    private lateinit var currencyAdapter: CurrencyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currencyAdapter = CurrencyAdapter()
        rvCurrency.layoutManager = LinearLayoutManager(this)
        rvCurrency.adapter = currencyAdapter

        getCurrencyNet()

    }

    fun getCurrencyNet() {
        ApiClient.instance.getCurrency().enqueue(object : Callback<CurrencyResponse> {
            override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.no_internet),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(
                call: Call<CurrencyResponse>,
                response: Response<CurrencyResponse>
            ) {

                if (response.isSuccessful) {
                    currencyAdapter.setItems(response.body()!!.currenyList!!)
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.error), Toast.LENGTH_SHORT)
                        .show()
                }

            }

        })
    }
}
