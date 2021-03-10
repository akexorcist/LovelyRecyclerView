package com.akexorcist.lovelyrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.lovelyrecyclerview.adapter.holder.ButtonViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.EmptyViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.NoOrderViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.NoticeViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.OrderViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.SectionViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.SummaryViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.TitleViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.TotalViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.holder.UserDetailViewHolder
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderDetailItem
import com.akexorcist.lovelyrecyclerview.databinding.ViewButtonBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewEmptyBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewNoOrderBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewNoticeBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewOrderBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewSectionBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewSummaryBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewTitleBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewTotalBinding
import com.akexorcist.lovelyrecyclerview.databinding.ViewUserDetailBinding

class OrderDetailAdapter(
    private val onPositiveButtonClicked: () -> Unit,
    private val onNegativeButtonClicked: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var orderDetailItems: List<OrderDetailItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        OrderDetailType.TYPE_USER_DETAIL ->
            UserDetailViewHolder(ViewUserDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_TITLE ->
            TitleViewHolder(ViewTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_SECTION ->
            SectionViewHolder(ViewSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_ORDER ->
            OrderViewHolder(ViewOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_SUMMARY ->
            SummaryViewHolder(ViewSummaryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_TOTAL ->
            TotalViewHolder(ViewTotalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_NOTICE ->
            NoticeViewHolder(ViewNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_BUTTON ->
            ButtonViewHolder(ViewButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_EMPTY ->
            EmptyViewHolder(ViewEmptyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        OrderDetailType.TYPE_NO_ORDER ->
            NoOrderViewHolder(ViewNoOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        else ->
            throw NullPointerException("View Type $viewType doesn't match with any existing order detail type")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        orderDetailItems.getOrNull(position)?.let { item ->
            when {
                holder is UserDetailViewHolder && item is OrderDetailItem.UserDetail ->
                    holder.bind(item)
                holder is TitleViewHolder && item is OrderDetailItem.Title ->
                    holder.bind(item)
                holder is SectionViewHolder && item is OrderDetailItem.Section ->
                    holder.bind(item)
                holder is OrderViewHolder && item is OrderDetailItem.Order ->
                    holder.bind(item)
                holder is SummaryViewHolder && item is OrderDetailItem.Summary ->
                    holder.bind(item)
                holder is TotalViewHolder && item is OrderDetailItem.Total ->
                    holder.bind(item)
                holder is ButtonViewHolder && item is OrderDetailItem.Button ->
                    holder.bind({ onPositiveButtonClicked.invoke() }, { onNegativeButtonClicked.invoke() })
                holder is NoticeViewHolder && item is OrderDetailItem.Notice -> { /* Do nothing */ }
                holder is EmptyViewHolder && item is OrderDetailItem.Empty -> { /* Do nothing */ }
                holder is NoOrderViewHolder && item is OrderDetailItem.NoOrder -> { /* Do nothing */ }
            }
        }
    }

    override fun getItemViewType(position: Int): Int = orderDetailItems.getOrNull(position)?.type ?: OrderDetailType.TYPE_EMPTY

    override fun getItemCount(): Int = orderDetailItems.size
}