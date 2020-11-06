package com.hermanzamula.rpn;

import java.math.BigDecimal;
import java.util.Arrays;

public class RpnStringEvaluator {
    private final RpnCalculatorBuilder builder;

    public RpnStringEvaluator() {
        this.builder = new RpnCalculatorBuilder();
    }

    private boolean isNumber(String num) {
        if (num == null) {
            return false;
        }
        try {
            Double.parseDouble(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private void applyToken(String token) {
        if (isNumber(token)) {
            builder.addOperand(new BigDecimal(token));
        } else {
            try {
                builder.applyOperator(OperatorsFactory.fromSign(token));
            } catch (RuntimeException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

    public BigDecimal evaluateLine(String line) {
        if (line == null || line.isEmpty()) {
            return builder.getResult();
        }

        Arrays.stream(line.split(" "))
                .map(String::trim)
                .filter((s) -> !s.isEmpty())
                .forEach(this::applyToken);

        return builder.getResult();
    }
}
