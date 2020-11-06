package com.hermanzamula;

import com.hermanzamula.rpn.RpnStringEvaluator;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final RpnStringEvaluator tokenizer = new RpnStringEvaluator();

        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();

            if (line.contains("quit")) {
                return;
            }

            final BigDecimal result = tokenizer.evaluateLine(line);

            System.out.println(result);
        }
    }
}
