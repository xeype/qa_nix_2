package com.xeype.entity;

import java.math.BigDecimal;

public class Sun extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(1.989E30);
    private BigDecimal radius = BigDecimal.valueOf(696340E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
