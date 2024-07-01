package com.Activity.sysarch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Document(collection = "activities")
public class Activity {
    @Id
    private String id;

    @Schema(description = "Name of the bangka", example = "MV Cebu", allowableValues = {"MV Cebu", "MV Banilad", "MV Xerxes", "MV Odette", "MV James", "MV Melgo", "MV Arvince", "MV Joem"})
    private String bangkasName;

    @Schema(description = "Name of the destination", example = "Bantayan", allowableValues = {"Bantayan", "Camotes", "Bohol", "Moalboal", "Olanggo", "Sumilon", "Malapascua", "Alegria"})
    private String destination;

    @Schema(description = "Date of the activity", type = "string", format = "date-time")
    private Date date;

    @Schema(description = "Total price", accessMode = Schema.AccessMode.READ_ONLY)
    private int totalPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBangkasName() {
        return bangkasName;
    }

    public void setBangkasName(String bangkasName) {
        this.bangkasName = bangkasName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
