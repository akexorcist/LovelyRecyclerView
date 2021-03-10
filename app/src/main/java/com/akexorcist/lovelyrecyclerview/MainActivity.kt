package com.akexorcist.lovelyrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.akexorcist.lovelyrecyclerview.adapter.OrderDetailAdapter
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem
import com.akexorcist.lovelyrecyclerview.databinding.ActivityMainBinding
import com.akexorcist.lovelyrecyclerview.network.FakeNetwork
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail
import com.akexorcist.lovelyrecyclerview.util.OrderDetailConverter
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var adapter: OrderDetailAdapter

    private var orderDetail: OrderDetail? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        loadOrderDetail()
    }

    private fun setupView() {
        adapter = OrderDetailAdapter(onPositiveButtonClicked, onNegativeButtonClicked)
        binding.rvOrderDetail.layoutManager = LinearLayoutManager(this)
        binding.rvOrderDetail.adapter = adapter
    }

    private fun loadOrderDetail() {
        FakeNetwork.getFakeOrderDetail { orderDetail ->
            this.orderDetail = orderDetail
            val convertedItems = convertToOrderDetailItems(orderDetail)
            updateOrderDetailItems(convertedItems)
        }
    }

    private fun convertToOrderDetailItems(orderDetail: OrderDetail): List<OrderDetailItem> {
        val name = "Sleeping For Less"
        val title = getString(R.string.your_order)
        val summaryTitle = getString(R.string.summary)

        val foodTitle = getString(R.string.food)
        val bookTitle = getString(R.string.book)
        val musicTitle = getString(R.string.music)
        val currency = getString(R.string.baht_unit)

        val foodTitleColor = ContextCompat.getColor(this, R.color.sky_light_blue)
        val bookTitleColor = ContextCompat.getColor(this, R.color.funny_dark_pink)
        val musicTitleColor = ContextCompat.getColor(this, R.color.natural_green)

        return if (isOrderDetailAvailable(orderDetail)) {
            mutableListOf<OrderDetailItem>().apply {
                add(OrderDetailConverter.createUserDetail(name))
                add(OrderDetailConverter.createTitle(title))
                addAll(OrderDetailConverter.createSectionAndOrder(orderDetail, foodTitle, bookTitle, musicTitle, currency, foodTitleColor, bookTitleColor, musicTitleColor))
                add(OrderDetailConverter.createTitle(summaryTitle))
                addAll(OrderDetailConverter.createSummary(orderDetail, foodTitle, bookTitle, musicTitle, currency))
                add(OrderDetailConverter.createTotal(orderDetail, currency))
                add(OrderDetailConverter.createNotice())
                add(OrderDetailConverter.createButton())
            }
        } else {
            mutableListOf<OrderDetailItem>().apply {
                add(OrderDetailConverter.createUserDetail(name))
                add(OrderDetailConverter.createTitle(title))
                add(OrderDetailConverter.createNoOrder())
                add(OrderDetailConverter.createTitle(summaryTitle))
                add(OrderDetailConverter.createTotal(orderDetail, currency))
            }
        }
    }

    private fun isOrderDetailAvailable(orderDetail: OrderDetail): Boolean {
        return orderDetail.foodList?.isNotEmpty() == true ||
                orderDetail.bookList?.isNotEmpty() == true ||
                orderDetail.musicList?.isNotEmpty() == true
    }

    private fun updateOrderDetailItems(newItems: List<OrderDetailItem>) {
        adapter.orderDetailItems = newItems
        adapter.notifyDataSetChanged()
    }

    private val onPositiveButtonClicked: () -> Unit = {
        Toast.makeText(this, "Positive button clicked", Toast.LENGTH_SHORT).show()
    }

    private val onNegativeButtonClicked: () -> Unit = {
        Toast.makeText(this, "Negative button clicked", Toast.LENGTH_SHORT).show()
    }
}
