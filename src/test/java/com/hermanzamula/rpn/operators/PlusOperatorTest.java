package com.hermanzamula.rpn.operators;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PlusOperatorTest {
    @Test
    public void testReturnsZeroIfOperandsAreEmpty() {
        final PlusOperator operator = new PlusOperator();

        final BigDecimal result = operator.evaluate();

        assertEquals(0, result.longValue());
    }
    
    @Test
    public void testSum() {
        final PlusOperator operator = new PlusOperator();

        final BigDecimal result = operator.evaluate(BigDecimal.valueOf(0.3), BigDecimal.valueOf(10));
        
        assertEquals(10.3, result.floatValue(), 0.01);
    }
}
