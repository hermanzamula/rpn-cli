package com.hermanzamula.rpn.operators;

import com.hermanzamula.rpn.Operator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class DivideOperator implements Operator {
    @Override
    public BigDecimal evaluate(BigDecimal... operands) {
        return Arrays.stream(operands).reduce((left, right) -> left.divide(right, MathContext.DECIMAL32)).orElse(BigDecimal.ZERO);
    }
}
