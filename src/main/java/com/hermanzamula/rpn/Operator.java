package com.hermanzamula.rpn;

import java.math.BigDecimal;

public interface Operator {
    BigDecimal evaluate(BigDecimal... operands);
}
