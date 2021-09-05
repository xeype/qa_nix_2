package com.xeype.entity;

import java.math.BigDecimal;

public class Saturn extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(568E24);
    private BigDecimal radius = BigDecimal.valueOf(58232E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
