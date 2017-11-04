package com.example.cm.resturant;

/**
 * Created by cm on 07/08/2017.
 */

public class data {

    String food,price,name,phone,address;


    public data(String food, String price, String name, String phone, String address) {
        this.food = food;
        this.price = price;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
