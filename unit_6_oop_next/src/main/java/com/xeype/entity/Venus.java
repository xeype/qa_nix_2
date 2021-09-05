package com.xeype.entity;

import java.math.BigDecimal;

public class Venus extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(4.87E24);
    private BigDecimal radius = BigDecimal.valueOf(6051.8E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
