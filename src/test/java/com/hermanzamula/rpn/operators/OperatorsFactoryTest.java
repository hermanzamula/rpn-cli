package com.hermanzamula.rpn.operators;

import com.hermanzamula.rpn.OperatorsFactory;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class OperatorsFactoryTest {
    @Test
    public void testPlusOperator() {
        assertThat(OperatorsFactory.fromSign("+"), is(instanceOf(PlusOperator.class)));
    }

    @Test
    public void testMinusOperator() {
        assertThat(OperatorsFactory.fromSign("-"), is(instanceOf(SubtractOperator.class)));
    }

    @Test
    public void testMultiplyOperator() {
        assertThat(OperatorsFactory.fromSign("*"), is(instanceOf(MultiplyOperator.class)));
    }

    @Test
    public void testDivideOperator() {
        assertThat(OperatorsFactory.fromSign("/"), is(instanceOf(DivideOperator.class)));
    }

    @Test(expected = RuntimeException.class)
    public void testThowsExceptionIfOperatorNotFound() {
        OperatorsFactory.fromSign("^");
        fail();
    }
}
