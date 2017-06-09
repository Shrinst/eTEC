package com.example.aguis.etecapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private String name;
    private String imageURL;
    private int id;
    private String description;
    private String category;
    private int amount;
    private int price;

    public Product() {

    }

    public Product(String name, String imageURL, int id, int amount, int price, String category, String description) {
        this.name = name;
        this.imageURL = imageURL;
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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


    protected Product(Parcel in) {
        name = in.readString();
        imageURL = in.readString();
        id = in.readInt();
        description = in.readString();
        category = in.readString();
        amount = in.readInt();
        price = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imageURL);
        dest.writeInt(id);
        dest.writeString(description);
        dest.writeString(category);
        dest.writeInt(amount);
        dest.writeInt(price);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}