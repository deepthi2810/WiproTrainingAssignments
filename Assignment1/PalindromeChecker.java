package wiprotraining;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String cleanedStr = input.replace(" ", "").toLowerCase();
        boolean isPalindrome = true;
        for (int i = 0; i < cleanedStr.length() / 2; i++) {
            if (cleanedStr.charAt(i) != cleanedStr.charAt(cleanedStr.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
  
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}

