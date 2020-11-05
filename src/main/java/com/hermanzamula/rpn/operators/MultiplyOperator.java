package com.hermanzamula.rpn.operators;

import com.hermanzamula.rpn.Operator;

import java.math.BigDecimal;
import java.util.Arrays;

public class MultiplyOperator implements Operator {
    @Override
    public BigDecimal evaluate(BigDecimal... operands) {
        return Arrays.stream(operands).reduce(BigDecimal::multiply).orElse(BigDecimal.ZERO);
    }
}
