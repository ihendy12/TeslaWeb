package com.ianhenderson.teslaconfigwebsite.model;

public class Trim {
    private int trimId;
    private String trimName;
    private double trimPrice;

    public Trim() {
    }

    public int getTrimId() {
        return trimId;
    }

    public void setTrimId(int trimId) {
        this.trimId = trimId;
    }

    public String getTrimName() {
        return trimName;
    }

    public void setTrimName(String trimName) {
        this.trimName = trimName;
    }

    public double getTrimPrice() {
        return trimPrice;
    }

    public void setTrimPrice(double trimPrice) {
        this.trimPrice = trimPrice;
    }
}
