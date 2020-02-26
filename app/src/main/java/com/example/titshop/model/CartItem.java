package com.example.titshop.model;

public class CartItem {
    Product product;
    String size;
    String numberItem;

    public CartItem() {
    }

    public CartItem(Product product, String size, String numberItem) {
        this.product = product;
        this.size = size;
        this.numberItem = numberItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNumberItem() {
        return numberItem;
    }

    public void setNumberItem(String numberItem) {
        this.numberItem = numberItem;
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
        return Integer.parseInt(getNumberItem()) * Float.parseFloat(product.price);
    }
}
