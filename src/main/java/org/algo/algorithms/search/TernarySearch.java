package org.algo.algorithms.search;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * author: doneskandari@gmail.com
 * date: 9/5/22 - 6:01 PM
 */
public class TernarySearch {

   public static void compare(int target, int[]... arrays) {
        Arrays.stream(arrays).forEach(a -> execute(target , a));
    }

    public static void execute(int target , int[] array) {
        Instant start = Instant.now();
        int result = search(0, array.length - 1, target, array);
        Instant end = Instant.now();
        System.out.println("execution time in nano seconds is " + Duration.between(start , end).toNanos());
        System.out.println("result of the algorithm execution is located in index " + result);
    }

    public static int search(int left , int right ,int target , int[] array) {
        if (right >= left) {
            // find two middle values
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            // check if key is present at any middle value
            if (array[mid1] == target)
                return mid1;
            if (array[mid2] == target)
                return mid2;

            // The key lies in between left and first middle
            if (target < array[mid1])
                return search(left, mid1 - 1, target, array);
                // The key lies in between second middle and right
            else if (target > array[mid2])
                return search(mid2 + 1, right, target, array);
                // The key lies in between first middle and second middle
            else
                return search(mid1 + 1, mid2 - 1, target, array);
        }
        return -1;
    }
}
