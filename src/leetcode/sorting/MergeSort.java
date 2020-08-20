package leetcode.sorting;

public class MergeSort {

    private void merge(int[] arr, int lo, int mid, int hi) {
        int len = hi - lo;
        int[] aux = new int[len];
        int k = 0, i = lo, j = mid;
        while (i < mid && j < hi) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }

        while (i < mid) {
            aux[k++] = arr[i++];
        }

        while (j < hi) {
            aux[k++] = arr[j++];
        }

        k = 0;
        while (lo < hi) {
            arr[lo++] = aux[k++];
        }
    }

    private void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    public void sort(int[] arr) {
        int lo = 0;
        int hi = arr.length;
        mergeSort(arr, lo, hi);
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] data = new int[]{12, 11, 13, 5, 6, 7};
        ms.sort(data);
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
