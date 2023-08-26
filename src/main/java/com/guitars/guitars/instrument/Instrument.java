package com.guitars.guitars.instrument;

import org.springframework.data.annotation.Id;

public abstract class Instrument {
    @Id
    protected int id;
    protected String serialNumber;
    protected String price;
    protected InstrumentSpec instrumentSpec;

    public Instrument(String serialNumber, String price, InstrumentSpec instrumentSpec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.instrumentSpec = instrumentSpec;
    }
    public Instrument(int id, String serialNumber, String price, InstrumentSpec instrumentSpec) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.price = price;
        this.instrumentSpec = instrumentSpec;
    }

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
