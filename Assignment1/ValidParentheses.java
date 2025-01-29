package wiprotraining;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string containing only {}, [], and (): ");
        String input = scanner.nextLine();

        if (isValid(input)) {
            System.out.println("The string is valid.");
        } else {
            System.out.println("The string is not valid.");
        }

        scanner.close();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
           
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; 
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false; 
                }
            } else {
                return false; 
            }
        }

        return stack.isEmpty();
    }

   
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}
