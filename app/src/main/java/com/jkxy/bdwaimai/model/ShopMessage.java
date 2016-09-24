package com.jkxy.bdwaimai.model;

/**
 * Created by X on 2016/3/26.
 */
public class ShopMessage {
    private int shopIcon=0;//商店Icon
    private String shopNmae="";//商店名称
    private float starNumber=0.0f;//评价星数
    private String peisong=""; //配送费
    private String sales="";//销量
    private String distance="";//距离
    private String qisong="";//起送量
    private String time="";//时间

    public int getShopIcon() {
        return shopIcon;
    }

    public void setShopIcon(int shopIcon) {
        this.shopIcon = shopIcon;
    }

    public String getShopNmae() {
        return shopNmae;
    }

    public void setShopNmae(String shopNmae) {
        this.shopNmae = shopNmae;
    }



    public float getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(float starNumber) {
        this.starNumber = starNumber;
    }



    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }



    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }



    public String getQisong() {
        return qisong;
    }

    public void setQisong(String qisong) {
        this.qisong = qisong;
    }



    public String getPeisong() {
        return peisong;
    }

    public void setPeisong(String peisong) {
        this.peisong = peisong;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
