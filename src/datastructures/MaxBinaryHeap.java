package datastructures;

public class MaxBinaryHeap {
    private final int[] arr;
    private int idx;

    public MaxBinaryHeap(int length) {
        idx = 0;
        arr = new int[length + 1];
    }

    public int getMax() {
        return arr[1];
    }

    public void insert(int num) {
        arr[++idx] = num;
        swim(idx);
    }

    private void swim(int k) {
        while (k > 1 && arr[k / 2] < arr[k]) {
            swap(k, k / 2);
            k = k / 2;
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
    }
}
