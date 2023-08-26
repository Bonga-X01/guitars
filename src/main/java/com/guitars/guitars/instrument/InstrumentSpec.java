package com.guitars.guitars.instrument;

public abstract class InstrumentSpec {
    protected String builder;
    protected String model;
    protected String type;
    protected String backWood;
    protected String topWood;

    public InstrumentSpec(String builder, String model, String type, String backWood, String topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }
}
