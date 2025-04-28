package Structures.Stack;

import java.util.HashMap;
import java.util.Stack;

public class RecordConverter {
    public static String convertToPolishRecord(String str){
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('^', 4);
        priorityMap.put('*', 3);
        priorityMap.put('/', 3);
        priorityMap.put('+', 2);
        priorityMap.put('-', 2);
        priorityMap.put('(', 1);

        StringBuilder polishStr = new StringBuilder();
        char[] arrStr = str.toCharArray();

        for (char letter : arrStr) {
            if (Character.isLetterOrDigit(letter)) {
                polishStr.append(letter).append(" ");
            } else if (letter == '(') {
                stack.push(letter);
            } else if (letter == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    polishStr.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else if (priorityMap.containsKey(letter)) {
                while (!stack.isEmpty() && priorityMap.get(stack.peek()) >= priorityMap.get(letter)) {
                    polishStr.append(stack.pop()).append(" ");
                }
                stack.push(letter);
            }
        }

        while (!stack.isEmpty()) {
            polishStr.append(stack.pop()).append(" ");
        }

        return polishStr.toString().trim();

    }
    //Перевод в префиксную запись
    private static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' ||
                ch == '*' || ch == '/' || ch == '^');
    }

    private static int operatorPrecedence(char op) {
        if (op == '^') return 3;
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return -1;
    }

    private static String convertInfixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int sz = s.length();

        for (int i = 0; i < sz; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                res.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && operatorPrecedence(s.charAt(i)) <=
                        operatorPrecedence(st.peek())) {
                    res.append(st.pop());
                }
                st.push(s.charAt(i));
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }

    static String convertToPrefix(String infix) {
        StringBuilder sb = new StringBuilder(infix);
        sb.reverse();
        infix = sb.toString();

        char[] chars = infix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }

        String postfix = convertInfixToPostfix(new String(chars));
        return new StringBuilder(postfix).reverse().toString();
    }
}
