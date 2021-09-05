package com.xeype.entity;

import java.math.BigDecimal;

public class Neptune extends BaseObject {

    private BigDecimal weight = BigDecimal.valueOf(102E24);
    private BigDecimal radius = BigDecimal.valueOf(24622E3);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getRadius() {
        return radius;
    }
}
