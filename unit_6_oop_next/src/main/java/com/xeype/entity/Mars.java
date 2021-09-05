package com.xeype.entity;

import java.math.BigDecimal;

public class Mars extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(6.42E23);
    private BigDecimal radius = BigDecimal.valueOf(3389.5E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
