package com.guitars.guitars.mandolin;

import com.guitars.guitars.instrument.InstrumentSpec;

public class MandolinSpec extends InstrumentSpec {
    String style;
    public MandolinSpec(String builder, String model, String type, String backWood, String topWood, String style) {
        super(builder, model, type, backWood, topWood);
        this.style = style;
    }
    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        String s = "MandolinSpec{" +
                "style='" + style + '\'' +
                ", builder='" + builder + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", backWood='" + backWood + '\'' +
                ", topWood='" + topWood + '\'' +
                '}';
        return s;
    }
}
