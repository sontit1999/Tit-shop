package com.example.titshop.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Cart")
public class CartItem {

    @PrimaryKey
    @NonNull private String id;
    String numberItem;
    private String name;

    private String mota;

    private String gia;

    private String linkanh;

    private String numberbuy;

    private String idtype;
    public CartItem() {
    }

    public CartItem(String numberItem, String id, String name, String mota, String gia, String linkanh, String numberbuy, String idtype) {
        this.numberItem = numberItem;
        this.id = id;
        this.name = name;
        this.mota = mota;
        this.gia = gia;
        this.linkanh = linkanh;
        this.numberbuy = numberbuy;
        this.idtype = idtype;
    }

    public String getNumberItem() {
        return numberItem;
    }

    public void setNumberItem(String numberItem) {
        this.numberItem = numberItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getLinkanh() {
        return linkanh;
    }

    public void setLinkanh(String linkanh) {
        this.linkanh = linkanh;
    }

    public String getNumberbuy() {
        return numberbuy;
    }

    public void setNumberbuy(String numberbuy) {
        this.numberbuy = numberbuy;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public void tang(){
        int numberNew = Integer.parseInt(this.numberItem) + 1;
        this.numberItem = numberNew + "";
    }
    public void giam(){
        int now = Integer.parseInt(this.numberItem);
        int numberNew = now - 1;
        this.numberItem = numberNew + "";

    }
    public float pay(){
        return Integer.parseInt(getNumberItem()) * Float.parseFloat(gia);
    }
}
