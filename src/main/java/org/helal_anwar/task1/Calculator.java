package org.helal_anwar.task1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    // Special character substitutions to handle negative signs in expressions
    private final String k1 = new String(Character.toChars(195));
    private final String k2 = new String(Character.toChars(196));
    private final String k3 = new String(Character.toChars(197));
    private final String k4 = new String(Character.toChars(198));
    private final String k5 = new String(Character.toChars(199));

    // Stores the parsed expression parts
    private final List<String> memory;

    // Constructor: initializes the calculator with an expression
    public Calculator(String exp) {
        String value = substitute(exp); // Replace special patterns
        memory = new ArrayList<>();
        Collections.addAll(memory, value.split("\\+")); // Split by '+' to handle addition

        // Handle leading negative sign
        if (Character.toString(exp.charAt(0)).equals("-")) {
            memory.set(0, "-" + memory.getFirst());
        }
    }

    // Substitute special patterns to avoid confusion with negative signs
    private String substitute(String va) {
        String val = (Character.toString(va.charAt(0)).equals("-")) ? va.substring(1) : va;
        val = val
                .replaceAll("/-", k1)
                .replaceAll("\\*-", k2)
                .replaceAll("\\^-", k3)
                .replaceAll("E\\+", k4)
                .replaceAll("E-", k5)
                .replaceAll("-", "+-"); // Convert subtraction to addition of negative
        return val;
    }

    // Revert substituted patterns back to original form
    private String resubstitute(String va) {
        return va
                .replaceAll(k1, "/-")
                .replaceAll(k2, "*-")
                .replaceAll(k3, "^-")
                .replaceAll(k4, "E+")
                .replaceAll(k5, "E-");
    }

    // Main method to solve the expression
    public double solve() {
        double finalValue = 0.0;
        for (String x : memory) {
            x = resubstitute(x); // Restore original expression

            // Handle multiplication, division, power
            if (x.contains("*")) {
                x = multiply(x.split("\\*"));
            } else if (x.contains("/")) {
                x = divide(x.split("/"));
            } else if (x.contains("^")) {
                x = power(x.split("\\^"));
            }

            // Handle factorial
            x = (x.contains("!")) ? factorial(x) : x;

            // Add to final result
            finalValue += Double.parseDouble(x);
        }
        return finalValue;
    }

    // Handles exponentiation
    private String power(String[] split) {
        double finalValue = split[0].contains("!") ? Double.parseDouble(factorial(split[0])) : Double.parseDouble(split[0]);
        for (int i = 1; i < split.length; i++) {
            String x = split[i];
            x = (x.contains("!")) ? factorial(x) : x;
            finalValue = Math.pow(finalValue, Double.parseDouble(x));
        }
        return String.valueOf(finalValue);
    }

    // Handles division
    private String divide(String[] split) {
        double finalValue = 1.0;
        for (int i = 0; i < split.length; i++) {
            String x = split[i];
            if (x.contains("^")) {
                x = power(x.split("\\^"));
            }
            x = (x.contains("!")) ? factorial(x) : x;
            finalValue = (i == 0) ? Double.parseDouble(x) : finalValue / Double.parseDouble(x);
        }
        return String.valueOf(finalValue);
    }

    // Handles multiplication
    private String multiply(String[] split) {
        double finalValue = 1.0;
        for (String x : split) {
            if (x.contains("/")) {
                x = divide(x.split("/"));
            } else if (x.contains("^")) {
                x = power(x.split("\\^"));
            }
            x = (x.contains("!")) ? factorial(x) : x;
            finalValue *= Double.parseDouble(x);
        }
        return String.valueOf(finalValue);
    }

    // Handles factorial expressions
    private String factorial(String x) {
        while (x.contains("!")) {
            x = x.replace(x.substring(0, x.indexOf('!') + 1), fac(new BigInteger(x.substring(0, x.indexOf('!')))));
        }
        return x;
    }

    // Converts BigInteger factorial result to string
    private String fac(BigInteger n) {
        return f(n).toString();
    }

    // Recursive factorial calculation
    private BigInteger f(BigInteger n) {
        return (n.compareTo(BigInteger.ONE) > 0) ? n.multiply(f(n.subtract(BigInteger.ONE))) : n;
    }

    public static void main(String[] args) {
        System.out.println("""
                \033[0;32m
                ___________.____        _________        .__               .__          __               \s
                \\_   _____/|    |       \\_   ___ \\_____  |  |   ____  __ __|  | _____ _/  |_  ___________\s
                 |    __)_ |    |       /    \\  \\/\\__  \\ |  | _/ ___\\|  |  \\  | \\__  \\\\   __\\/  _ \\_  __ \\
                 |        \\|    |___    \\     \\____/ __ \\|  |_\\  \\___|  |  /  |__/ __ \\|  | (  <_> )  | \\/
                /_______  /|_______ \\    \\______  (____  /____/\\___  >____/|____(____  /__|  \\____/|__|  \s
                        \\/         \\/           \\/     \\/          \\/                \\/                  \s
                                                                                                            (v.0.1)
                \33[0m
                \033[0;34m
                📱 About This Calculator
                Welcome to the Simple Math Calculator – your go-to tool for quick and efficient mathematical operations!
                
                ✨ Features:
                Addition – Add two numbers with ease.
                Subtraction – Subtract one number from another.
                Multiplication – Multiply numbers for fast results.
                Division – Divide numbers with precision.
                Factorial – Calculate the factorial of a number.
                Power – Calculate the a^b.
                Enter 'e' – Close the calculator when you're done.
                Enter 'cls' - To clear the screen
                🛠️ Purpose:
                This calculator is designed to be lightweight, user-friendly, and perfect for basic arithmetic tasks. Whether you're a student, teacher, or just someone who needs quick calculations, this tool is here to help.
                
                🚀 How to Use:
                Just simply write your expression
                Example 2+3+4*3/4-6
                
                📌 Note:
                This calculator is a learning project aimed at practicing programming logic and user interaction. Future updates may include more advanced functions and a graphical interface.
                 \33[0m
                """);
        System.out.println("Enter your expression or 'e' to exit: ");
        try (Scanner in = new Scanner(System.in)) {
            String exp = in.nextLine();
            while (!exp.equals("e")) {
                if (exp.equals("cls")) {
                    System.out.println("\033[H\033[2J");
                    System.out.println("Enter your expression or 'e' to exit: ");
                    exp = in.nextLine();
                    if (exp.equals("e"))
                        break;
                }
                if (exp.isBlank()) {
                    System.err.println("Invalid expression: " + exp);
                } else {
                    var cal = new Calculator(exp);
                    try {
                        System.out.println("\033[0;32m" + cal.solve() + " \33[0m");
                    } catch (ArithmeticException e) {
                        System.err.println("Bad expression: " + exp + " is not allow");
                    } catch (Exception e) {
                        System.err.println("Invalid expression: " + exp);
                    }
                }
                System.out.println("Enter your expression or 'e' to exit: ");
                exp = in.nextLine();

            }
            System.out.println("Thanks for using it :)\nVisit again");
        }
    }
}
