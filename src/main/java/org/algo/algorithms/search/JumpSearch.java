package org.algo.algorithms.search;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * author: doneskandari@gmail.com
 * date: 9/5/22 - 6:01 PM
 */
public class JumpSearch {

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

    public static int search(int target ,int[] array) {
        // block size is square root of array length
        int blockSize = (int) Math.sqrt(array.length);

        int currentLastIndex = blockSize - 1;

        while (currentLastIndex < array.length && target > array[currentLastIndex])
            currentLastIndex += blockSize;

        for (int i = currentLastIndex ; i > currentLastIndex - blockSize ; i--) {
            if (target == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
