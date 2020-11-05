package com.hermanzamula.rpn;

import org.junit.Test;

import java.math.BigDecimal;

import static com.hermanzamula.rpn.OperatorsFactory.fromSign;
import static org.junit.Assert.assertEquals;

public class RpnCalculatorBuilderTest {
    @Test
    public void testMultipleOperators() {
        final RpnCalculatorBuilder builder = new RpnCalculatorBuilder();

        final BigDecimal result = builder.addOperand(1, 2).addOperand(3).applyOperator(fromSign("+"), fromSign("-")).getResult();

        assertEquals(-4, result.longValue());
    }

    @Test
    public void testProvidesIntermediateResults() {
        final RpnCalculatorBuilder builder = new RpnCalculatorBuilder();

        BigDecimal result = builder.addOperand(1, 2).addOperand(3).applyOperator(fromSign("+")).getResult();

        assertEquals(5, result.longValue());

        result = builder.applyOperator(fromSign("-")).getResult();

        assertEquals(-4, result.longValue());
    }
}
