package com.hermanzamula.rpn;

import com.hermanzamula.rpn.operators.DivideOperator;
import com.hermanzamula.rpn.operators.MultiplyOperator;
import com.hermanzamula.rpn.operators.PlusOperator;
import com.hermanzamula.rpn.operators.SubtractOperator;

public class OperatorsFactory {
    public static Operator fromSign(String sign) {
        return switch (sign) {
            case "+" -> new PlusOperator();
            case "-" -> new SubtractOperator();
            case "/" -> new DivideOperator();
            case "*" -> new MultiplyOperator();
            default -> throw new RuntimeException("Undefined operator: \"" + sign + "\"");
        };
    }
}
