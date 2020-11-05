package com.hermanzamula.rpn.operators;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SubtractOperatorTest {
    @Test
    public void testReturnsZeroIfOperandsAreEmpty() {
        final SubtractOperator operator = new SubtractOperator();

        final BigDecimal result = operator.evaluate();

        assertEquals(0, result.longValue());
    }  
    
    @Test
    public void testSubtract() {
        final SubtractOperator operator = new SubtractOperator();

        final BigDecimal result = operator.evaluate(BigDecimal.valueOf(10), BigDecimal.valueOf(.3));

        assertEquals(9.7, result.floatValue(), 0.01);
    }
}
