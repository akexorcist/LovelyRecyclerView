package com.akexorcist.lovelyrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.akexorcist.lovelyrecyclerview.adapter.OrderAdapter;
import com.akexorcist.lovelyrecyclerview.adapter.model.BaseOrderDetailItem;
import com.akexorcist.lovelyrecyclerview.network.FakeNetwork;
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail;
import com.akexorcist.lovelyrecyclerview.utility.OrderDetailConverter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OrderAdapter.OnItemClickListener {
    private RecyclerView rvOrderDetail;
    private OrderAdapter orderAdapter;

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
                setOrderDetail(orderDetail);
            }
        });
    }

    private void setOrderDetail(OrderDetail orderDetail) {
        String name = "Sleeping For Less";
        String yourOrderTitle = getString(R.string.your_order);
        String summaryTitle = getString(R.string.summary);

        String foodTitle = getString(R.string.food);
        String bookTitle = getString(R.string.book);
        String musicTitle = getString(R.string.music);
        String currency = getString(R.string.baht_unit);

        List<BaseOrderDetailItem> orderDetailItemList = new ArrayList<>();
        orderDetailItemList.add(OrderDetailConverter.createUserDetail(name));
        orderDetailItemList.add(OrderDetailConverter.createTitle(yourOrderTitle));
        orderDetailItemList.addAll(OrderDetailConverter.createSectionAndOrder(orderDetail, foodTitle, bookTitle, musicTitle, currency));
        orderDetailItemList.add(OrderDetailConverter.createTitle(summaryTitle));
        orderDetailItemList.addAll(OrderDetailConverter.createSummary(orderDetail, foodTitle, bookTitle, musicTitle, currency));
        orderDetailItemList.add(OrderDetailConverter.createTotal(orderDetail, currency));
        orderDetailItemList.add(OrderDetailConverter.createNotice());
        orderDetailItemList.add(OrderDetailConverter.createButton());
        orderDetailItemList.add(OrderDetailConverter.createEmpty());

        orderAdapter.setOrderItemList(orderDetailItemList);
        orderAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPositiveButtonClick() {
        Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_SHORT).show();
    }
}
