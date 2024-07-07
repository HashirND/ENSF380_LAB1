package com.hashir.calculator;

import java.util.Scanner;
import java.lang.Math; // This import is needed for sqrt

public class Application {
    public static void main(String[] args) {
        if (args.length > 0) {
            processCLIArguments(args);
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide, sqrt, factorial):");
            String operation = scanner.next();
            // Further processing based on operation

            switch (operation.toLowerCase()) {
                case "add":
                    System.out.println("Enter the first operand:");
                    double num1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    double num2 = scanner.nextDouble();
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case "subtract":
                    System.out.println("Enter the first operand:");
                    num1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + subtract(num1, num2));
                    break;
                case "multiply":
                    System.out.println("Enter the first operand:");
                    num1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + multiply(num1, num2));
                    break;
                case "divide":
                    System.out.println("Enter the first operand:");
                    num1 = scanner.nextDouble();
                    System.out.println("Enter the second operand:");
                    num2 = scanner.nextDouble();
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero!");
                    } else {
                        System.out.println("Result: " + divide(num1, num2));
                    }
                    break;
                case "sqrt":
                    System.out.println("Enter a number:");
                    double number = scanner.nextDouble();
                    if (number < 0) {
                        System.out.println("Error: Square root of a negative number!");
                    } else {
                        System.out.println("Result: " + sqrt(number));
                    }
                    break;
                case "factorial":
                    System.out.println("Enter a non-negative number:");
                    int num = scanner.nextInt(); // Ensures non-negative input (int for factorial)
                    if (num < 0) {
                        System.out.println("Error: Factorial is not defined for negative numbers!");
                    } else {
                        System.out.println("Result: " + factorial(num));
                    }
                    break;
                default:
                    System.out.println("Invalid operation!");
            }
            scanner.close(); // Closing the scanner to prevent resource leaks
        }
    }

    public static void processCLIArguments(String[] args) {
        // Check for the correct number of arguments
        if (args.length != 3) {
            System.out.println("Usage: java Application <operation> <operand1> <operand2>");
            return;
        }

        String operation = args[0];
        double num1 = Double.parseDouble(args[1]);
        double num2 = Double.parseDouble(args[2]);

        double result = 0;
        boolean validOperation = true;

        switch (operation.toLowerCase()) {
            case "add":
                result = add(num1, num2);
                break;
            case "subtract":
                result = subtract(num1, num2);
                break;
            case "multiply":
                result = multiply(num1, num2);
                break;
            case "divide":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero!");
                    validOperation = false;
                } else {
                    result = divide(num1, num2);
                }
                break;
            default:
                System.out.println("Invalid operation!");
                validOperation = false;
        }

        if (validOperation) {
            System.out.println("Result: " + result);
        }
    }

    // addition method
    public static double add(double a, double b) {
        return a + b;
    }

    // subtraction method
    public static double subtract(double a, double b) {
        return a - b;
    }

    // multiplication method
    public static double multiply(double a, double b) {
        return a * b;
    }

    // division, also if the number is invalid itll return
    public static double divide(double a, double b) {
        if (b == 0) {
            return Double.NaN; // Not a Number
        } else {
            return a / b;
        }
    }

    // square root method that also checks for errors
    public static double sqrt(double number) {
        if (number < 0) {
            return Double.NaN; // Not a Number
        } else {
            return Math.sqrt(number);
        }
    }

    // factorial method with progress display
    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers!");
            return 0;
        }
        return factorialHelper(num);
    }

    // Helper method for factorial with progress display
    private static long factorialHelper(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
            int progress = (int) ((i / (double) num) * 100);
            System.out.print("\rCalculating factorial: " + progress + "%");
        }
        System.out.println("\rCalculating factorial: 100%");
        return result;
    }
}



