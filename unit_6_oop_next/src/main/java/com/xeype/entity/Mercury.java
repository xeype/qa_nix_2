package com.xeype.entity;

import java.math.BigDecimal;

public class Mercury extends BaseObject {

    private final BigDecimal weight = BigDecimal.valueOf(3.3E23);
    private final BigDecimal radius = BigDecimal.valueOf(2439.7E3);

    public BigDecimal getRadius() {
        return radius;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}
