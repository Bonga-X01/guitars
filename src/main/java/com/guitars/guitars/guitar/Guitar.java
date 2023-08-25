package com.guitars.guitars.guitar;

import com.guitars.guitars.instrument.Instrument;
import org.springframework.data.annotation.Id;

public class Guitar extends Instrument {
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
