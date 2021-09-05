package com.xeype.entity;

import java.math.BigDecimal;

public class Uranus extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(86.8E24);
    private BigDecimal radius = BigDecimal.valueOf(25362E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
