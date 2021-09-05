package com.xeype.entity;

import java.math.BigDecimal;

public class Moon extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(7.36E22);
    private BigDecimal radius = BigDecimal.valueOf(1737.4E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
