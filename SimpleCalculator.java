import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Simple Calculator!");

        while (true) {
            double num1 = getNumber(scanner, "Enter the first number: ");
            double num2 = getNumber(scanner, "Enter the second number: ");
            int choice = getOperationChoice(scanner);

            double result;
            boolean validOperation = true;
            switch (choice) {
                case 1 -> {
                    result = add(num1, num2);
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                }
                case 2 -> {
                    result = subtract(num1, num2);
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                }
                case 3 -> {
                    result = multiply(num1, num2);
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                }
                case 4 -> {
                    if (num2 != 0) {
                        result = divide(num1, num2);
                        System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                    } else {
                        System.out.println("Error: Division by zero.");
                        validOperation = false;
                    }
                }
                default -> {
                    System.out.println("Invalid choice. Please select a valid operation.");
                    validOperation = false;
                }
            }

            if (validOperation) {
                System.out.print("Do you want to perform another calculation? (yes/no): ");
                String anotherCalculation = scanner.next().toLowerCase();
                if (!anotherCalculation.equals("yes")) {
                    System.out.println("Goodbye!");
                    break;
                }
            }
        }

        scanner.close();
    }

    private static double getNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static int getOperationChoice(Scanner scanner) {
        System.out.println("\nSelect an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter the operation number: ");
        return scanner.nextInt();
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double subtract(double a, double b) {
        return a - b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static double divide(double a, double b) {
        return a / b;
    }
}
