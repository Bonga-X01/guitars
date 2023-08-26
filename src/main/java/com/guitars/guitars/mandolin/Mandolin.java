package com.guitars.guitars.mandolin;

import com.guitars.guitars.instrument.Instrument;
import com.guitars.guitars.instrument.InstrumentSpec;

public class Mandolin extends Instrument {
    InstrumentSpec spec;
    public Mandolin(String serialNumber, String price, MandolinSpec spec) {
        super(serialNumber, price, spec);
    }
    public Mandolin(int id, String serialNumber, String price, MandolinSpec spec) {
        super(id, serialNumber, price, spec);
    }

    public InstrumentSpec getSpec() {
        return spec;
    }
}
