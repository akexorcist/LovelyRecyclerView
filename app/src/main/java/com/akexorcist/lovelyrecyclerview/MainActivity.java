package com.akexorcist.lovelyrecyclerview;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.akexorcist.lovelyrecyclerview.adapter.OrderAdapter;
import com.akexorcist.lovelyrecyclerview.adapter.model.BaseOrderDetailItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderItem;
import com.akexorcist.lovelyrecyclerview.network.FakeNetwork;
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail;
import com.akexorcist.lovelyrecyclerview.utility.OrderDetailConverter;
import com.akexorcist.lovelyrecyclerview.utility.OrderListDiffCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OrderAdapter.OnItemClickListener {
    private RecyclerView rvOrderDetail;
    private OrderAdapter orderAdapter;

    private OrderDetail orderDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupView();
        callService();
    }

    private void bindView() {
        rvOrderDetail = (RecyclerView) findViewById(R.id.rv_order_detail);
    }

    private void setupView() {
        rvOrderDetail.setLayoutManager(new LinearLayoutManager(this));
        orderAdapter = new OrderAdapter();
        orderAdapter.setOnItemClickListener(this);
        rvOrderDetail.setAdapter(orderAdapter);
    }

    private void callService() {
        FakeNetwork.getFakeOrderDetail(new FakeNetwork.OnResultCallback() {
            @Override
            public void onOrderDetailCallback(OrderDetail orderDetail) {
                MainActivity.this.orderDetail = orderDetail;
                List<BaseOrderDetailItem> orderDetailItemList = createOrderDetailList(orderDetail);
                List<BaseOrderDetailItem> emptyList = new ArrayList<>();
                updateOrderDetailList(emptyList, orderDetailItemList);
            }
        });
    }

    private List<BaseOrderDetailItem> createOrderDetailList(OrderDetail orderDetail) {
        String name = "Sleeping For Less";
        String yourOrderTitle = getString(R.string.your_order);
        String summaryTitle = getString(R.string.summary);

        String foodTitle = getString(R.string.food);
        String bookTitle = getString(R.string.book);
        String musicTitle = getString(R.string.music);
        String currency = getString(R.string.baht_unit);

        int foodTitleColor = ContextCompat.getColor(this, R.color.sky_light_blue);
        int bookTitleColor = ContextCompat.getColor(this, R.color.funny_dark_pink);
        int musicTitleColor = ContextCompat.getColor(this, R.color.natural_green);

        List<BaseOrderDetailItem> orderDetailItemList = new ArrayList<>();
        orderDetailItemList.add(OrderDetailConverter.createUserDetail(name));
        if (isOrderDetailAvailable(orderDetail)) {
            orderDetailItemList.add(OrderDetailConverter.createTitle(yourOrderTitle));
            orderDetailItemList.addAll(OrderDetailConverter.createSectionAndOrder(orderDetail, foodTitle, bookTitle, musicTitle, currency, foodTitleColor, bookTitleColor, musicTitleColor));
            orderDetailItemList.add(OrderDetailConverter.createTitle(summaryTitle));
            orderDetailItemList.addAll(OrderDetailConverter.createSummary(orderDetail, foodTitle, bookTitle, musicTitle, currency));
            orderDetailItemList.add(OrderDetailConverter.createTotal(orderDetail, currency));
            orderDetailItemList.add(OrderDetailConverter.createNotice());
            orderDetailItemList.add(OrderDetailConverter.createButton());
        } else {
            orderDetailItemList.add(OrderDetailConverter.createTitle(yourOrderTitle));
            orderDetailItemList.add(OrderDetailConverter.createNoOrder());
            orderDetailItemList.add(OrderDetailConverter.createTitle(summaryTitle));
            orderDetailItemList.add(OrderDetailConverter.createTotal(orderDetail, currency));
        }
        orderDetailItemList.add(OrderDetailConverter.createEmpty());
        return orderDetailItemList;
    }

    private void updateOrderDetailList(List<BaseOrderDetailItem> oldOrderItemList, List<BaseOrderDetailItem> newOrderItemList) {
        orderAdapter.setOrderItemList(newOrderItemList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new OrderListDiffCallback(oldOrderItemList, newOrderItemList));
        diffResult.dispatchUpdatesTo(orderAdapter);
    }

    private boolean isOrderDetailAvailable(OrderDetail orderDetail) {
        return orderDetail != null &&
                ((orderDetail.getFoodList() != null && !orderDetail.getFoodList().isEmpty()) ||
                        (orderDetail.getBookList() != null && !orderDetail.getBookList().isEmpty()) ||
                        (orderDetail.getMusicList() != null && !orderDetail.getMusicList().isEmpty()));
    }

    @Override
    public void onPositiveButtonClick() {
        Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOrderRemove(OrderItem orderItem, int position) {
        List<BaseOrderDetailItem> oldOrderItemList = createOrderDetailList(orderDetail);
        boolean isOrderRemoved = removeOrder(orderDetail, orderItem);
        List<BaseOrderDetailItem> newOrderItemList = createOrderDetailList(orderDetail);

        if (isOrderRemoved) {
            updateOrderDetailList(oldOrderItemList, newOrderItemList);
            Toast.makeText(this, "Order " + orderItem.getName() + " was removed", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean removeOrder(OrderDetail orderDetail, OrderItem orderItem) {
        if (orderDetail != null) {
            int index = getFoodOrderIndex(orderDetail.getFoodList(), orderItem);
            if (index != -1) {
                orderDetail.getFoodList().remove(index);
                return true;
            }
            index = getBookOrderIndex(orderDetail.getBookList(), orderItem);
            if (index != -1) {
                orderDetail.getBookList().remove(index);
                return true;
            }
            index = getMusicOrderIndex(orderDetail.getMusicList(), orderItem);
            if (index != -1) {
                orderDetail.getMusicList().remove(index);
                return true;
            }
        }
        return false;
    }

    private int getFoodOrderIndex(List<OrderDetail.Food> foodOrderDetailList, OrderItem orderItem) {
        if (foodOrderDetailList != null && orderItem != null) {
            for (int index = 0; index < foodOrderDetailList.size(); index++) {
                OrderDetail.Food food = foodOrderDetailList.get(index);
                if (food.getOrderName().equals(orderItem.getName())) {
                    return index;
                }
            }
        }
        return -1;
    }

    private int getBookOrderIndex(List<OrderDetail.Book> bookOrderDetailList, OrderItem orderItem) {
        if (bookOrderDetailList != null && orderItem != null) {
            for (int index = 0; index < bookOrderDetailList.size(); index++) {
                OrderDetail.Book book = bookOrderDetailList.get(index);
                if (book.getBookName().equals(orderItem.getName())) {
                    return index;
                }
            }
        }
        return -1;
    }

    private int getMusicOrderIndex(List<OrderDetail.Music> musicOrderDetailList, OrderItem orderItem) {
        if (musicOrderDetailList != null && orderItem != null) {
            for (int index = 0; index < musicOrderDetailList.size(); index++) {
                OrderDetail.Music music = musicOrderDetailList.get(index);
                if (music.getAlbum().equals(orderItem.getName())) {
                    return index;
                }
            }
        }
        return -1;
    }
}
