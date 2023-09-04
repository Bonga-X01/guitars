package com.guitars.guitars.mandolin;

import com.guitars.guitars.instrument.Instrument;
import com.guitars.guitars.instrument.InstrumentSpec;

public class Mandolin extends Instrument {

    MandolinSpec spec;

    public Mandolin(String serialNumber, String price, MandolinSpec spec) {
        super(serialNumber, price, spec);
        this.spec = spec;
        System.err.println(spec + "from mandolin constr");
    }
    public Mandolin(int id, String serialNumber, String price, MandolinSpec spec) {
        super(id, serialNumber, price, spec);
        this.spec = spec;
    }

    public MandolinSpec getSpec() {
        return spec;
    }

    @Override
    public String toString() {
        return "Mandolin{" +
                "spec=" + spec +
                ", id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", price='" + price + '\'' +
                ", instrumentSpec=" + instrumentSpec +
                '}';
    }
}
