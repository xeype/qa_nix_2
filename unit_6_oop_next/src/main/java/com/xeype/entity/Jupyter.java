package com.xeype.entity;

import java.math.BigDecimal;

public class Jupyter extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(1898E24);
    private BigDecimal radius = BigDecimal.valueOf(69911E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
