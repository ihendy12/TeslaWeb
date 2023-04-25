package com.ianhenderson.teslaconfigwebsite.model;

public class Exterior {
    private int exteriorId;
    private String exteriorName;
    private double exteriorPrice;

    public Exterior() {
    }

    public int getExteriorId() {
        return exteriorId;
    }

    public void setExteriorId(int exteriorId) {
        this.exteriorId = exteriorId;
    }

    public String getExteriorName() {
        return exteriorName;
    }

    public void setExteriorName(String exteriorName) {
        this.exteriorName = exteriorName;
    }

    public double getExteriorPrice() {
        return exteriorPrice;
    }

    public void setExteriorPrice(double exteriorPrice) {
        this.exteriorPrice = exteriorPrice;
    }
}
