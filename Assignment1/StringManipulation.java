package wiprotraining;

import java.util.HashMap;
import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        input = input.toLowerCase();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

       
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }

        System.out.println("Character Frequency:");
        for (char key : frequencyMap.keySet()) {
            System.out.println(key + ": " + frequencyMap.get(key));
        }

        scanner.close();
    }
}
