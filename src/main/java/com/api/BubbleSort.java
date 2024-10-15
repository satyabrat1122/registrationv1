package com.api;




import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // Sample array to be sorted
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array: " + Arrays.toString(array));

        // Call the bubbleSort method
        bubbleSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // Bubble Sort algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // Get the length of the array
        boolean swapped; // Flag to track if a swap occurred

        // Loop through each element in the array
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Initialize swapped as false for this iteration

            // Inner loop for comparison
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Mark that a swap occurred
                }
            }

            // If no swaps occurred, the array is sorted
            if (!swapped) {
                break; // Exit the loop early
            }
        }
    }
}
