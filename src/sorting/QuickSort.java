package sorting;

import leetcode.may_april_june_challenge.Helper;

public class QuickSort {
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int j = partition(a, lo, hi);
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]) {
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

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = Helper.parseIntegerArray("[1001,0,1,5,99,0,1,293588]");
        qs.sort(arr);
        Helper.prettyPrint(arr);
        arr = new int[]{12, -2, 11, 13, -1, 5, 6, 7, 2, 1, 6, -2};
        qs.sort(arr);
        Helper.prettyPrint(arr);
    }
}
