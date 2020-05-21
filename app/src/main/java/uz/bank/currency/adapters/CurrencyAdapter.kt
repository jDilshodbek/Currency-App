package uz.bank.currency.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.currency_item.view.*
import uz.bank.currency.R
import uz.bank.currency.models.Currency

class CurrencyAdapter () : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>(){
    var currencyList= listOf<Currency>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.currency_item,parent,false)
    )

    override fun getItemCount()=currencyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(currencyList[position])
    }

    fun setItems(currencyList: List<Currency>){
        this.currencyList=currencyList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val buyCourse=itemView.tvBuyCourse
        private val sellCourse=itemView.tvSellCourse
        private val cbCourse=itemView.tvCbCourse
        private val currencyText=itemView.tvCurrency
        private val currencyCode=itemView.tvCurrencyCode
        private val scale=itemView.tvScale

        fun bindData(currency: Currency){
            buyCourse.text="${currency.buyCourse}"
            sellCourse.text="${currency.sellCourse}"
            cbCourse.text="${currency.cbCourse}"
            currencyText.text=currency.currency
            currencyCode.text="${currency.currencyCode}"
            scale.text="${currency.scale}"
        }

    }

}