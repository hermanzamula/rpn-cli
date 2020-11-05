package com.hermanzamula.rpn;

import java.math.BigDecimal;
import java.util.Stack;

public class RpnCalculatorBuilder {
    private final Stack<BigDecimal> operandsStack;

    private BigDecimal currentResult;

    public RpnCalculatorBuilder() {
        this.operandsStack = new Stack<>();
        this.currentResult = BigDecimal.ZERO;
    }

    public RpnCalculatorBuilder addOperand(Number... num) {
        for (Number number : num) {
            this.operandsStack.push(new BigDecimal(number.toString()));
        }
        return this;
    }

    public RpnCalculatorBuilder applyOperator(Operator... operators) {
        for (Operator operator : operators) {
            this.currentResult = calculateResult(operator);
            this.operandsStack.push(this.currentResult);
        }
        return this;
    }

    public BigDecimal getResult() {
        return currentResult;
    }

    private BigDecimal calculateResult(Operator operator) {
        final BigDecimal right = this.operandsStack.pop();
        final BigDecimal left = this.operandsStack.pop();

        return operator.evaluate(left, right);
    }
}
