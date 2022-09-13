package org.algo.algorithms.search;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * author: doneskandari@gmail.com
 * date: 9/5/22 - 6:01 PM
 */
public class BinarySearch {

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
        while (low <= high) {
            // find middle
            // NOTE: we also can perform (high + low) / 2 , but it's not preferred because if sum of high and low become larger than integer max value, it will cause overflow.
            int middle = low + (high - low) / 2;

            // if middle is equal to target then return the value
            if (array[middle] == target)
                return middle;

            // eliminate the right side of the list
            if (array[middle] < target)
                low = middle + 1;
            // eliminate the left side of the list
            else
                high = middle - 1;
        }
        return -1;
    }
}
