package codechef.dsa_learning_series.LRNDSA01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SmartClass {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        Integer[] arr = new Integer[total];
        for (int i = 0; i < total; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        long max_profit = Long.MIN_VALUE, curr_profit;
        for (int i = 0; i < total; i++) {
            curr_profit = arr[i];
            curr_profit *= (i + 1);
            max_profit = Math.max(max_profit, curr_profit);
        }
        System.out.println(max_profit);
    }
}
