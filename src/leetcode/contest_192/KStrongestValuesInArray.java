package leetcode.contest_192;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KStrongestValuesInArray {

    private int medianOfArray(int[] a) {
        List<Integer> ar = Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList());
        Collections.sort(ar);
        return ar.get((ar.size() - 1) / 2);
    }

    public int[] getStrongest(int[] arr, int k) {
        int m = medianOfArray(arr);
        List<Integer> ar = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        Collections.sort(ar, (a, b) -> (Math.abs(a - m) == Math.abs(b - m)) ? b - a : Math.abs(b - m) - Math.abs(a - m));
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = ar.get(i);
        return res;
    }

    public static void main(String[] args) {
        KStrongestValuesInArray kstrong = new KStrongestValuesInArray();
        // Test Case: arr = [1,2,3,4,5], k = 2
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) arr[i] = i + 1;
        int[] res = kstrong.getStrongest(arr, 2);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
