package com.guitars.guitars.guitar;

import com.guitars.guitars.instrument.Instrument;

public class Guitar extends Instrument {

    GuitarSpec spec;

    public Guitar(String serialNumber, String price, GuitarSpec spec) {
        super(serialNumber, price, spec);
        this.spec = spec;
    }

    public Guitar(int id, String serialNumber, String price, GuitarSpec spec) {
        super(id, serialNumber, price, spec);
        this.spec = spec;
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
