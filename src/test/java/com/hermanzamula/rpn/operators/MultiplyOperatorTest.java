package com.hermanzamula.rpn.operators;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MultiplyOperatorTest {
    @Test
    public void testMultiply() {
        final MultiplyOperator operator = new MultiplyOperator();

        final BigDecimal result = operator.evaluate(BigDecimal.valueOf(10), BigDecimal.valueOf(0.5));
        
        assertEquals(5, result.longValue());
    }    
    
    @Test
    public void testReturnsZeroIfOperandsAreEmpty() {
        final MultiplyOperator operator = new MultiplyOperator();

        final BigDecimal result = operator.evaluate();
        
        assertEquals(0, result.longValue());
    }
}
