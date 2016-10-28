package com.akexorcist.lovelyrecyclerview.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderDetail {
    @SerializedName("food_list")
    private List<Food> foodList;

    @SerializedName("book_list")
    private List<Book> bookList;

    @SerializedName("music_list")
    private List<Music> musicList;

    public OrderDetail() {
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public static class Food {
        @SerializedName("order_name")
        private String orderName;
        private int amount;
        private int price;

        public Food() {
        }

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public static class Book {
        @SerializedName("ISBN")
        private String isbn;
        @SerializedName("book_name")
        private String bookName;
        private String author;
        @SerializedName("publish_date")
        private String publishDate;
        private String publication;
        private int price;
        private int pages;

        public Book() {
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getPublication() {
            return publication;
        }

        public void setPublication(String publication) {
            this.publication = publication;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }
    }

    public static class Music {
        private String artist;
        private String album;
        @SerializedName("release_date")
        private String releaseDate;
        private int track;
        private int price;

        public Music() {
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public int getTrack() {
            return track;
        }

        public void setTrack(int track) {
            this.track = track;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
