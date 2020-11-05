package com.hermanzamula.rpn;

import com.hermanzamula.rpn.operators.DivideOperator;
import com.hermanzamula.rpn.operators.MultiplyOperator;
import com.hermanzamula.rpn.operators.PlusOperator;
import com.hermanzamula.rpn.operators.SubtractOperator;

public class OperatorsFactory {
    public static Operator fromSign(String sign) {
        switch (sign) {
            case "+":
                return new PlusOperator();
            case "-":
                return new SubtractOperator();
            case "/":
                return new DivideOperator();
            case "*":
                return new MultiplyOperator();
            default:
                throw new RuntimeException("Undefined operator: \"" + sign + "\"");
        }
    }
}
