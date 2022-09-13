package org.algo.algorithms.search;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * author: doneskandari@gmail.com
 * date: 9/5/22 - 6:01 PM
 */
public class ExponentialSearch {

   public static void compare(int target, int[]... arrays) {
        Arrays.stream(arrays).forEach(a -> execute(target , a));
    }

    public static void execute(int target , int[] array) {
        Instant start = Instant.now();
        int result = search(target, array);
        Instant end = Instant.now();
        System.out.println("execution time in nano seconds is " + Duration.between(start , end).toNanos());
        System.out.println("result of the algorithm execution is located in index " + result);
    }

    public static int search(int target , int[] array) {
       int low = 0;
       int high = array.length - 1;

        if (array[low] == target)
            return 0;

        // find range by repeated doubling
        low = 1;
        while (low < high && array[low] <= target)
            low *= 2;

        // redefine the higher and lower bound
        if (low < high) {
            high = low;
            low = high / 2;
        } else
            low = low / 2;

        // then perform a binary search
        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] == target)
                return middle;

            if (array[middle] < target)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return -1;
    }
}
