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
public class InsertionSort {

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
        for (int i = 1 ; i < array.length ; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}
