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
public class BubbleSort {

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
        int temp;
        for(int i = 0 ; i < array.length ; i++){
            for(int j = 1 ; j < array.length - i ; j++){
                if(array[j-1] > array[j]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }
}
