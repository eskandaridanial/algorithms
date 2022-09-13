package org.algo.algorithms.problem;

/**
 * author: doneskandari@gmail.com
 * date: 9/7/22 - 5:02 PM
 */
public class ArrayProblems {

    public static int[] moveNegativeElementsToFrontOfAnArray() {
        int[] array = {1,2,-10,3,4,5,6,-1,-5};

        int high = array.length - 1;
        int low = 0;

        while (low < high) {

            // if high and low values are both negative, increment low bound by one
            if (array[high] < 0 && array[low] < 0)
                low = low + 1;

            // if high value is negative and low value is positive swap the values
            if (array[high] < 0 && array[low] > 0) {
                int temp = array[high];
                array[high] = array[low];
                array[low] = temp;

                // then increment low bound by one and decrement high bound by one
                high = high - 1;
                low = low + 1;
            } else {
                // if none of above condition happened, then increment low bound by one and decrement high bound by one
                high = high - 1;
                low = low + 1;
            }
        }
        return array;
    }
}
