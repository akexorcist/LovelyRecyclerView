package com.akexorcist.lovelyrecyclerview.utility;

import android.support.v7.util.DiffUtil;

import com.akexorcist.lovelyrecyclerview.adapter.model.BaseOrderDetailItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.SectionItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.SummaryItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.TotalItem;

import java.util.List;

/**
 * Created by Akexorcist on 11/4/2016 AD.
 */

public class OrderListDiffCallback extends DiffUtil.Callback {
    private List<BaseOrderDetailItem> oldOrderItemList;
    private List<BaseOrderDetailItem> newOrderItemList;

    public OrderListDiffCallback(List<BaseOrderDetailItem> oldOrderItemList, List<BaseOrderDetailItem> newOrderItemList) {
        this.oldOrderItemList = oldOrderItemList;
        this.newOrderItemList = newOrderItemList;
    }

    @Override
    public int getOldListSize() {
        return oldOrderItemList != null ? oldOrderItemList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newOrderItemList != null ? newOrderItemList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        BaseOrderDetailItem newOrderDetailItem = newOrderItemList.get(newItemPosition);
        BaseOrderDetailItem oldOrderDetailItem = oldOrderItemList.get(newItemPosition);
        if (newOrderDetailItem.getType() == oldOrderDetailItem.getType()) {
            if (newOrderDetailItem instanceof SectionItem) {
                SectionItem newSectionItem = (SectionItem) newOrderDetailItem;
                SectionItem oldSectionItem = (SectionItem) oldOrderDetailItem;
                return newSectionItem.getSection().equals(oldSectionItem.getSection());

            } else if (newOrderDetailItem instanceof OrderItem) {
                OrderItem newOrderItem = (OrderItem) newOrderDetailItem;
                OrderItem oldOrderItem = (OrderItem) oldOrderDetailItem;
                return newOrderItem.getName().equals(oldOrderItem.getName());

            } else if (newOrderDetailItem instanceof SummaryItem) {
                SummaryItem newSummaryItem = (SummaryItem) newOrderDetailItem;
                SummaryItem oldSummaryItem = (SummaryItem) oldOrderDetailItem;
                return newSummaryItem.getName().equals(oldSummaryItem.getName());

            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        BaseOrderDetailItem newOrderDetailItem = newOrderItemList.get(newItemPosition);
        BaseOrderDetailItem oldOrderDetailItem = oldOrderItemList.get(newItemPosition);
        if (newOrderDetailItem.getType() == oldOrderDetailItem.getType()) {
            if (newOrderDetailItem instanceof SectionItem) {
                SectionItem newSectionItem = (SectionItem) newOrderDetailItem;
                SectionItem oldSectionItem = (SectionItem) oldOrderDetailItem;
                return newSectionItem.getSection().equals(oldSectionItem.getSection()) &&
                        newSectionItem.getBackgroundColor() == oldSectionItem.getBackgroundColor();

            } else if (newOrderDetailItem instanceof OrderItem) {
                OrderItem newOrderItem = (OrderItem) newOrderDetailItem;
                OrderItem oldOrderItem = (OrderItem) oldOrderDetailItem;
                return newOrderItem.getName().equals(oldOrderItem.getName()) &&
                        newOrderItem.getDetail().equals(oldOrderItem.getDetail()) &&
                        newOrderItem.getPrice().equals(oldOrderItem.getPrice());

            } else if (newOrderDetailItem instanceof SummaryItem) {
                SummaryItem newSummaryItem = (SummaryItem) newOrderDetailItem;
                SummaryItem oldSummaryItem = (SummaryItem) oldOrderDetailItem;
                return newSummaryItem.getName().equals(oldSummaryItem.getName()) &&
                        newSummaryItem.getPrice().equals(oldSummaryItem.getPrice());

            } else if (newOrderDetailItem instanceof TotalItem) {
                TotalItem newTotalItem = (TotalItem) newOrderDetailItem;
                TotalItem oldTotalItem = (TotalItem) oldOrderDetailItem;
                return newTotalItem.getTotalPrice().equals(oldTotalItem.getTotalPrice());

            } else {
                return true;
            }
        }
        return false;
    }
}
