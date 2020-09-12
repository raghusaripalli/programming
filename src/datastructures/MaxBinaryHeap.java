package datastructures;

import java.util.Arrays;

public class MaxBinaryHeap {
    private final int[] arr;
    private int idx;

    public MaxBinaryHeap(int length) {
        idx = 0;
        arr = new int[length + 1];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }

    public int getMax() {
        return arr[1];
    }

    public void insert(int num) {
        arr[++idx] = num;
        swim(idx);
    }

    public int delete() {
        int max = arr[1];
        swap(1, idx--);
        arr[idx + 1] = Integer.MIN_VALUE;
        sink();
        return max;
    }

    private void swim(int k) {
        while (k > 1 && arr[k / 2] < arr[k]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink() {
        int N = arr.length;
        int k = 1;
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && arr[j] < arr[j + 1]) j++;
            if (arr[k] >= arr[j]) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        MaxBinaryHeap heap = new MaxBinaryHeap(3);
        heap.insert(1);
        System.out.println(heap.getMax());
        heap.insert(2);
        System.out.println(heap.getMax());
        heap.insert(3);
        System.out.println(heap.getMax());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
        System.out.println(heap.delete());
    }
}
