package com.atguigu.crud.bean;

public class Restaurant {
    private String restaurantName;

    private String restaurantAddress;

    private String restaurantNotice;

    private String restaurantAccount;

    private String restaurantPassword;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName == null ? null : restaurantName.trim();
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress == null ? null : restaurantAddress.trim();
    }

    public String getRestaurantNotice() {
        return restaurantNotice;
    }

    public void setRestaurantNotice(String restaurantNotice) {
        this.restaurantNotice = restaurantNotice == null ? null : restaurantNotice.trim();
    }

    public String getRestaurantAccount() {
        return restaurantAccount;
    }

    public void setRestaurantAccount(String restaurantAccount) {
        this.restaurantAccount = restaurantAccount == null ? null : restaurantAccount.trim();
    }

    public String getRestaurantPassword() {
        return restaurantPassword;
    }

    public void setRestaurantPassword(String restaurantPassword) {
        this.restaurantPassword = restaurantPassword == null ? null : restaurantPassword.trim();
    }
}