package com.atguigu.crud.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Orders {
    private Integer orderId;

    private Integer userId;

    private Integer orderTable;

    private Integer orderStatus;

    private Float orderPrice;

    private String orderComment;

    private String orderRemarks;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderPayment;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderFinish;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(Integer orderTable) {
        this.orderTable = orderTable;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment == null ? null : orderComment.trim();
    }

    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks == null ? null : orderRemarks.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(Date orderPayment) {
        this.orderPayment = orderPayment;
    }

    public Date getOrderFinish() {
        return orderFinish;
    }

    public void setOrderFinish(Date orderFinish) {
        this.orderFinish = orderFinish;
    }
}