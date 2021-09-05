package com.xeype.entity;

import java.math.BigDecimal;

public class Earth extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(5.97E24);
    private BigDecimal radius = BigDecimal.valueOf(6371E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
