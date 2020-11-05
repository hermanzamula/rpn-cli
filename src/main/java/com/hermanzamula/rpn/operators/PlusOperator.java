package com.hermanzamula.rpn.operators;

import com.hermanzamula.rpn.Operator;

import java.math.BigDecimal;
import java.util.Arrays;

public class PlusOperator implements Operator {
    @Override
    public BigDecimal evaluate(BigDecimal... operands) {
        return Arrays.stream(operands).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
