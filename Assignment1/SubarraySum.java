package wiprotraining;

import java.util.Scanner;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int maxSum = array[0];
        int currentSum = array[0];

        for (int i = 1; i < size; i++) {
            currentSum = (array[i] > currentSum + array[i]) ? array[i] : currentSum + array[i];
            maxSum = (currentSum > maxSum) ? currentSum : maxSum;
        } 
        System.out.println("Maximum subarray sum: " + maxSum);
        scanner.close();
    }
}
