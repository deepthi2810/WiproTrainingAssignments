package wiprotraining;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        // Example input array
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Find the maximum subarray sum
        int maxSum = findMaxSubarraySum(array);

        // Display the result
        System.out.println("The maximum sum of a contiguous subarray is: " + maxSum);
    }

    public static int findMaxSubarraySum(int[] array) {
        int maxSum = Integer.MIN_VALUE; // Initialize with the smallest possible value
        int currentSum = 0;

        // Iterate through the array
        for (int num : array) {
            // Update currentSum dynamically
            currentSum = (currentSum + num > num) ? currentSum + num : num;

            // Update maxSum if currentSum is larger
            maxSum = (currentSum > maxSum) ? currentSum : maxSum;
        }

        return maxSum;
    }
}
