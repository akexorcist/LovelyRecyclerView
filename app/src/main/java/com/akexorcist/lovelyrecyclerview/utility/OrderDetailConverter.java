package com.akexorcist.lovelyrecyclerview.utility;

import com.akexorcist.lovelyrecyclerview.adapter.model.BaseOrderDetailItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.ButtonItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.EmptyItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.NoticeItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.OrderItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.SectionItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.SummaryItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.TitleItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.TotalItem;
import com.akexorcist.lovelyrecyclerview.adapter.model.UserDetailItem;
import com.akexorcist.lovelyrecyclerview.network.response.OrderDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akexorcist on 10/28/2016 AD.
 */

public class OrderDetailConverter {

    public static UserDetailItem createUserDetail(String name) {
        UserDetailItem userDetailItem = new UserDetailItem();
        userDetailItem.setName(name);
        return userDetailItem;
    }

    public static TitleItem createTitle(String yourOrderTitle) {
        TitleItem titleItem = new TitleItem();
        titleItem.setTitle(yourOrderTitle);
        return titleItem;
    }

    public static TotalItem createTotal(OrderDetail orderDetail, String currency) {
        TotalItem totalItem = new TotalItem();
        totalItem.setTotalPrice(getTotalPrice(orderDetail) + currency);
        return totalItem;
    }

    private static int getTotalPrice(OrderDetail orderDetail) {
        int totalPrice = 0;
        totalPrice += getTotalFoodPrice(orderDetail.getFoodList());
        totalPrice += getTotalBookPrice(orderDetail.getBookList());
        totalPrice += getTotalMusicPrice(orderDetail.getMusicList());
        return totalPrice;
    }

    private static int getTotalFoodPrice(List<OrderDetail.Food> foodList) {
        int totalFoodPrice = 0;
        if (foodList != null) {
            for (OrderDetail.Food food : foodList) {
                totalFoodPrice += food.getPrice();
            }
        }
        return totalFoodPrice;
    }

    private static int getTotalBookPrice(List<OrderDetail.Book> bookList) {
        int totalBookPrice = 0;
        if (bookList != null) {
            for (OrderDetail.Book book : bookList) {
                totalBookPrice += book.getPrice();
            }
        }
        return totalBookPrice;
    }

    private static int getTotalMusicPrice(List<OrderDetail.Music> musicList) {
        int totalMusicPrice = 0;
        if (musicList != null) {
            for (OrderDetail.Music music : musicList) {
                totalMusicPrice += music.getPrice();
            }
        }
        return totalMusicPrice;
    }

    public static NoticeItem createNotice() {
        return new NoticeItem();
    }

    public static ButtonItem createButton() {
        return new ButtonItem();
    }

    public static EmptyItem createEmpty() {
        return new EmptyItem();
    }

    public static List<BaseOrderDetailItem> createSectionAndOrder(OrderDetail orderDetail, String foodTitle, String bookTitle, String musicTitle, String currency) {
        List<BaseOrderDetailItem> orderDetailItemList = new ArrayList<>();
        orderDetailItemList.addAll(getFoodOrderDetailList(orderDetail.getFoodList(), foodTitle, currency));
        orderDetailItemList.addAll(getBookOrderDetailList(orderDetail.getBookList(), bookTitle, currency));
        orderDetailItemList.addAll(getMusicOrderDetailList(orderDetail.getMusicList(), musicTitle, currency));
        return orderDetailItemList;
    }

    private static List<BaseOrderDetailItem> getFoodOrderDetailList(List<OrderDetail.Food> foodList, String foodTitle, String currency) {
        List<BaseOrderDetailItem> foodOrderDetailList = new ArrayList<>();
        if (foodList != null && foodList.size() > 0) {
            foodOrderDetailList.add(createSection(foodTitle));
            for (OrderDetail.Food food : foodList) {
                String name = food.getOrderName();
                String detail = "x" + food.getAmount();
                String price = food.getPrice() + currency;
                foodOrderDetailList.add(createOrder(name, detail, price));
            }
        }
        return foodOrderDetailList;
    }

    private static List<BaseOrderDetailItem> getBookOrderDetailList(List<OrderDetail.Book> bookList, String bookTitle, String currency) {
        List<BaseOrderDetailItem> bookOrderDetailList = new ArrayList<>();
        if (bookList != null && bookList.size() > 0) {
            bookOrderDetailList.add(createSection(bookTitle));
            for (OrderDetail.Book book : bookList) {
                String name = book.getBookName();
                String detail = book.getAuthor();
                String price = book.getPrice() + currency;
                bookOrderDetailList.add(createOrder(name, detail, price));
            }
        }
        return bookOrderDetailList;
    }

    private static List<BaseOrderDetailItem> getMusicOrderDetailList(List<OrderDetail.Music> musicList, String musicTitle, String currency) {
        List<BaseOrderDetailItem> musicOrderDetailList = new ArrayList<>();
        if (musicList != null && musicList.size() > 0) {
            musicOrderDetailList.add(createSection(musicTitle));
            for (OrderDetail.Music music : musicList) {
                String name = music.getAlbum();
                String detail = music.getArtist();
                String price = music.getPrice() + currency;
                musicOrderDetailList.add(createOrder(name, detail, price));
            }
        }
        return musicOrderDetailList;
    }

    private static SectionItem createSection(String title) {
        SectionItem sectionItem = new SectionItem();
        sectionItem.setSection(title);
        return sectionItem;
    }

    private static OrderItem createOrder(String name, String detail, String price) {
        OrderItem orderItem = new OrderItem();
        orderItem.setName(name);
        orderItem.setDetail(detail);
        orderItem.setPrice(price);
        return orderItem;
    }

    public static List<SummaryItem> createSummary(OrderDetail orderDetail, String foodTitle, String bookTitle, String musicTitle, String currency) {
        List<SummaryItem> summaryItemList = new ArrayList<>();
        if (orderDetail != null) {
            summaryItemList.addAll(getFoodSummary(orderDetail.getFoodList(), foodTitle, currency));
            summaryItemList.addAll(getBookSummary(orderDetail.getBookList(), bookTitle, currency));
            summaryItemList.addAll(getMusicSummary(orderDetail.getMusicList(), musicTitle, currency));
        }
        return summaryItemList;
    }

    private static List<SummaryItem> getFoodSummary(List<OrderDetail.Food> foodList, String foodTitle, String currency) {
        List<SummaryItem> foodSummaryItemList = new ArrayList<>();
        if (foodList != null && foodList.size() > 0) {
            SummaryItem summaryItem = new SummaryItem();
            summaryItem.setName(foodTitle);
            summaryItem.setPrice(getTotalFoodPrice(foodList) + currency);
            foodSummaryItemList.add(summaryItem);
        }
        return foodSummaryItemList;
    }

    private static List<SummaryItem> getBookSummary(List<OrderDetail.Book> bookList, String bookTitle, String currency) {
        List<SummaryItem> bookSummaryItemList = new ArrayList<>();
        if (bookList != null && bookList.size() > 0) {
            SummaryItem summaryItem = new SummaryItem();
            summaryItem.setName(bookTitle);
            summaryItem.setPrice(getTotalBookPrice(bookList) + currency);
            bookSummaryItemList.add(summaryItem);
        }
        return bookSummaryItemList;
    }

    private static List<SummaryItem> getMusicSummary(List<OrderDetail.Music> musicList, String musicTitle, String currency) {
        List<SummaryItem> bookSummaryItemList = new ArrayList<>();
        if (musicList != null && musicList.size() > 0) {
            SummaryItem summaryItem = new SummaryItem();
            summaryItem.setName(musicTitle);
            summaryItem.setPrice(getTotalMusicPrice(musicList) + currency);
            bookSummaryItemList.add(summaryItem);
        }
        return bookSummaryItemList;
    }
}
