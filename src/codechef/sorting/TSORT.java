package codechef.sorting;

import java.util.Scanner;

// https://www.codechef.com/problems/TSORT
// Turbo Sort
public class TSORT {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[lo] > a[++i]) {
                if (i == hi) break;
            }

            while (a[lo] < a[--j]) {
                if (j == lo) break;
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void qsort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int j = partition(a, lo, hi);
            qsort(a, lo, j - 1);
            qsort(a, j + 1, hi);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] arr = new int[total];
        for (int i = 0; i < total; i++) {
            arr[i] = sc.nextInt();
        }
        qsort(arr, 0, total - 1);
        for (int i = 0; i < total; i++) {
            System.out.println(arr[i]);
        }
    }
}
