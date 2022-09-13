package org.algo.algorithms.search;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * author: doneskandari@gmail.com
 * date: 9/5/22 - 6:01 PM
 */
public class InterpolationSearch {

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
        int high = array.length -1;
        int low = 0;

        while (target >= array[low] && target <= array[high] && low <= high) {
            int probe = low + (high - low) * (target - array[low]) / (array[high] - array[low]);

            if (high == low) {
                if (array[low] == target)
                    return low;
                else
                    return -1;
            }

            if (array[probe] == target)
                return probe;

            // redefine lower bound
            if (array[probe] < target)
                low = probe + 1;
            // redefine higher bound
            else
                high = probe - 1;
        }
        return -1;
    }
}
