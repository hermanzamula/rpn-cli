package com.hermanzamula;

import com.hermanzamula.rpn.OperatorsFactory;
import com.hermanzamula.rpn.RpnCalculatorBuilder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    private static boolean isNumber(String num) {
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

    private static void addTokenToBuilder(RpnCalculatorBuilder builder, String token) {
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

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final RpnCalculatorBuilder builder = new RpnCalculatorBuilder();

        while (scanner.hasNextLine()) {
            final String next = scanner.nextLine();

            if (next.contains("quit")) {
                return;
            }

            Arrays.stream(next.split(" "))
                    .map(String::trim)
                    .filter(Predicate.not(String::isEmpty))
                    .forEach((String token) -> addTokenToBuilder(builder, token));

            System.out.println(builder.getResult());
        }
    }
}
