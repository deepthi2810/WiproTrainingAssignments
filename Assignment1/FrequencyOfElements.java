package wiprotraining;

import java.util.Scanner;

public class FrequencyOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Input array elements
        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Array to store frequency and track visited elements
        int[] frequency = new int[size];
        for (int i = 0; i < size; i++) {
            frequency[i] = -1; // Initialize as -1 to mark unprocessed elements
        }

        // Calculate frequencies
        for (int i = 0; i < size; i++) {
            int count = 1; // Initialize count for the current element
            if (frequency[i] == -1) { // Process only unvisited elements
                for (int j = i + 1; j < size; j++) {
                    if (array[i] == array[j]) {
                        count++;
                        frequency[j] = 0; // Mark as visited
                    }
                }
                frequency[i] = count; // Store the frequency of the element
            }
        }

        // Display results
        System.out.println("Element | Frequency");
        for (int i = 0; i < size; i++) {
            if (frequency[i] != 0) { // Display only unique elements
                System.out.println("   " + array[i] + "    |    " + frequency[i]);
            }
        }

        scanner.close();
    }
}
