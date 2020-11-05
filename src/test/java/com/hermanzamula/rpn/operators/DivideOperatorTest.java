package com.hermanzamula.rpn.operators;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DivideOperatorTest {
    @Test
    public void testDivision() {
        final DivideOperator operator = new DivideOperator();

        final BigDecimal result = operator.evaluate(BigDecimal.valueOf(10), BigDecimal.valueOf(0.5));

        Assert.assertEquals(result.longValue(), 20);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        final DivideOperator operator = new DivideOperator();

        operator.evaluate(BigDecimal.valueOf(10), BigDecimal.valueOf(0));

        Assert.fail("Division by zero should throw an exception");
    }

    @Test
    public void testReturnsZeroIfOperandsAreEmpty() {
        final DivideOperator operator = new DivideOperator();

        final BigDecimal result = operator.evaluate();

        assertEquals(0, result.longValue());
    }
}
