package com.xeype.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ObjectImpl implements Object {

    private final BigDecimal GRAVITYCONST = BigDecimal.valueOf(6.67E-11);

    @Override
    public BigDecimal getAcceleration(BigDecimal radius, BigDecimal weight) {
        return GRAVITYCONST.multiply(weight.divide(radius.pow(2), 2, RoundingMode.HALF_EVEN));
    }
}
