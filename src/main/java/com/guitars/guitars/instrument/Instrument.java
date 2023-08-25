package com.guitars.guitars.instrument;

import org.springframework.data.annotation.Id;

public abstract class Instrument {
    @Id
    protected int id;
    protected String serialNumber;
    protected String price;

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
