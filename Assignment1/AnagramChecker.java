package wiprotraining;

import java.util.Arrays;

public class AnagramChecker {
    public static void main(String[] args) {
      
        String str1 = "Listen";
        String str2 = "Silent";

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (areAnagrams(str1, str2)) {
            System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are anagrams.");
        } else {
            System.out.println("\"" + str1 + "\" and \"" + str2 + "\" are not anagrams.");
        }
    }

    public static boolean areAnagrams(String str1, String str2) {
        
        if (str1.length() != str2.length()) {
            return false;
        }

        
        int[] charCounts = new int[26];

        for (char c : str1.toCharArray()) {
            if (Character.isLetter(c)) {
                charCounts[c - 'a']++;
            }
        }

        for (char c : str2.toCharArray()) {
            if (Character.isLetter(c)) {
                charCounts[c - 'a']--;
            }
        }

     
        for (int count : charCounts) {
            if (count != 0) {
                return false; 
            }
        }

        return true; }
}

