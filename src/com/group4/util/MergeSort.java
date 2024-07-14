package com.group4.util;

/**
 * The MergeSort class provides a static method `mergeSort` to sort a 2D array
 * of Objects based on a specified column index.
 */
public class MergeSort {

    /**
     * Sorts a 2D array using the mergesort algorithm based on a specified column index.
     *
     * @param array       The 2D array of Objects to be sorted.
     * @param columnIndex The index of the column to sort by.
     */
  
     //[11,12,13,14]

    public static void mergeSort(Object[][] array, int columnIndex) {
        // Check if the array has more than one element
        if (array.length > 1) {
            int mid = array.length / 2; // Find the middle index

            // Split the array into left and right parts
            Object[][] left = new Object[mid][array[0].length];
            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }

            Object[][] right = new Object[array.length - mid][array[0].length];
            for (int i = mid; i < array.length; i++) {
                right[i - mid] = array[i];
            }

            // Recursively sort the left and right parts
            mergeSort(left, columnIndex);
            mergeSort(right, columnIndex);

            int i = 0, j = 0, k = 0;

            // Merge the sorted left and right arrays into array
            while (i < left.length && j < right.length) {
                // Compare elements based on the specified column index
                if (((Comparable) left[i][columnIndex]).compareTo(right[j][columnIndex]) <= 0) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            }

            // Copy remaining elements of left array, if any
            while (i < left.length) {
                array[k++] = left[i++];
            }

            // Copy remaining elements of right array, if any
            while (j < right.length) {
                array[k++] = right[j++];
            }
        }
    }
}
