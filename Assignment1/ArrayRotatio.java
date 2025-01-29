package wiprotraining;

import java.util.Scanner;

public class ArrayRotatio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter 'L' for left rotation or 'R' for right rotation: ");
        char direction = scanner.next().toUpperCase().charAt(0);

        System.out.print("Enter the number of rotations: ");
        int rotations = scanner.nextInt();
        rotations %= size;
 
        if (direction == 'L') {
            rotateLeft(array, rotations);
        } else if (direction == 'R') {
            rotateRight(array, rotations);
        } else {
            System.out.println("Invalid direction! Please enter 'L' or 'R'.");
            return;
        }

        System.out.println("Rotated array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void rotateLeft(int[] array, int rotations) {
        int size = array.length;
        reverse(array, 0, rotations - 1);       
        reverse(array, rotations, size - 1);   
        reverse(array, 0, size - 1);           
    }

    public static void rotateRight(int[] array, int rotations) {
        int size = array.length;
        reverse(array, 0, size - rotations - 1); 
        reverse(array, size - rotations, size - 1); 
        reverse(array, 0, size - 1);               
    }
 
    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
