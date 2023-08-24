package com.guitars.guitars.guitar;

import org.springframework.data.annotation.Id;

public class Guitar {
    @Id
    private int id;
    private String serialNumber;
    private String price;
    GuitarSpec spec;

    public Guitar(String serialNumber, String builder, String model, String type, String backWood, String topWood, String price, int numString) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = new GuitarSpec(builder, model, type, backWood, topWood, numString);
    }

    public Guitar(int id, String serialNumber, String builder, String model, String type, String backWood, String topWood, String price, int numString) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = new GuitarSpec(builder, model, type, backWood, topWood, numString);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public GuitarSpec getSpec() {
        return spec;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", price='" + price + '\'' +
                ", spec=" + spec +
                '}';
    }
}
