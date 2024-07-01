package com.Activity.sysarch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bangkaPrices")
public class BangkaPrice {
    @Id
    private String id;
    private String bangkaName;
    private int price;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBangkaName() {
        return bangkaName;
    }

    public void setBangkaName(String bangkaName) {
        this.bangkaName = bangkaName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
