package com.guitars.guitars.guitar;

import com.guitars.guitars.instrument.InstrumentSpec;

public class GuitarSpec extends InstrumentSpec {
    protected int numStrings;
    public GuitarSpec(String builder, String model, String type, String backWood, String topWood, int numStrings) {
        super(builder, model, type, backWood, topWood);
        this.numStrings = numStrings;
    }

    public int getNumStrings() {
        return numStrings;
    }

    @Override
    public String toString() {
        return "GuitarSpec{" +
                "builder='" + builder + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", backWood='" + backWood + '\'' +
                ", topWood='" + topWood + '\'' +
                '}';
    }
}
