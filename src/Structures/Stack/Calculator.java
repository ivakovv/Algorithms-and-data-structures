package Structures.Stack;


import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип записи выражения:");
        System.out.println("1 - Польская (постфиксная) запись");
        System.out.println("2 - Префиксная запись");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите выражение (без пробелов):");
        String expression = scanner.nextLine();

        System.out.println("Введите значения операндов (если есть буквенные переменные):");
        System.out.println("Формат: a=1 b=2 c=3 ...");
        String variablesInput = scanner.nextLine();

        // Парсинг значений переменных
        java.util.Map<String, Double> variables = new java.util.HashMap<>();
        if (!variablesInput.isEmpty()) {
            String[] varPairs = variablesInput.split(" ");
            for (String pair : varPairs) {
                String[] parts = pair.split("=");
                if (parts.length == 2) {
                    variables.put(parts[0], Double.parseDouble(parts[1]));
                }
            }
        }

        double result = 0;
        if (choice == 1) {
            result = evaluatePostfix(RecordConverter.convertToPolishRecord(expression), variables);
        } else if (choice == 2) {
            result = evaluatePrefix(RecordConverter.convertToPrefix(expression).replace("", " ").trim(), variables);
        } else {
            System.out.println("Неверный выбор типа записи");
            return;
        }

        System.out.println("Результат вычисления: " + result);
    }

    public static double evaluatePostfix(String expression, java.util.Map<String, Double> variables) {
        StackOnList<Double> stack = new StackOnList<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = applyOperator(token, operand1, operand2);
                stack.push(result);
            } else {
                double value;
                if (Character.isLetter(token.charAt(0))) {
                    value = variables.getOrDefault(token, 0.0);
                } else {
                    value = Double.parseDouble(token);
                }
                stack.push(value);
            }
        }

        return stack.pop();
    }

    public static double evaluatePrefix(String expression, java.util.Map<String, Double> variables) {
        StackOnList<Double> stack = new StackOnList<>();
        String[] tokens = expression.split(" ");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperator(token)) {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                double result = applyOperator(token, operand1, operand2);
                stack.push(result);
            } else {
                double value;
                if (Character.isLetter(token.charAt(0))) {
                    value = variables.getOrDefault(token, 0.0);
                } else {
                    value = Double.parseDouble(token);
                }
                stack.push(value);
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") ||
                token.equals("^");
    }

    private static double applyOperator(String operator, double a, double b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "^": return Math.pow(a, b);
            default: throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }
}


