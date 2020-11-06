package com.hermanzamula.rpn;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class RpnStringEvaluatorTest {
    @Test
    public void testIgnoresNullOrEmptyString() {
        final RpnStringEvaluator evaluator = new RpnStringEvaluator();
        assertThat(evaluator.evaluateLine(null), nullValue(BigDecimal.class));
        assertThat(evaluator.evaluateLine(""), nullValue(BigDecimal.class));
    }

    @Test
    public void testEvaluatesRpnStrings() {
        final RpnStringEvaluator evaluator = new RpnStringEvaluator();

        assertThat(evaluator.evaluateLine("5 10 20 + -").intValue(), is(-25));
        assertThat(evaluator.evaluateLine("5 10 - 20 +").intValue(), is(-25));
    }

    @Test
    public void testIgnoresErroredInput() {
        final RpnStringEvaluator evaluator = new RpnStringEvaluator();

        final BigDecimal result = evaluator.evaluateLine("5 10 20abracadabr + ");
        assertThat("should evaluate latest valid tokens", result.intValue(), is(15));
    }
}
