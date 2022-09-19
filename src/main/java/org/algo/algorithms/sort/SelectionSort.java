package org.algo.algorithms.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: doneskandari@gmail.com
 * date: 9/5/22 - 6:01 PM
 */
public class SelectionSort {

   public static List<int[]> compare(int[]... arrays) {
        List<int[]> result = new ArrayList<>();
        Arrays.stream(arrays).forEach(array -> result.add(execute(array)));
        return result;
    }

    public static int[] execute(int[] array) {
        Instant start = Instant.now();
        int[] result = sort(array);
        Instant end = Instant.now();
        System.out.println("execution time in nano seconds is " + Duration.between(start , end).toNanos());
        return result;
    }

    public static int[] sort(int[] array){
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = i + 1 ; j < array.length ; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
